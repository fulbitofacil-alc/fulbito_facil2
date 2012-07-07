/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Usuario;
import excepcion.DAOExcepcion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.ConexionBD;
import java.util.Calendar;


import excepcion.DAOExcepcion;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import modelo.EventoDeportivo;

/**
 *
 * @author operador
 */
public class EventoDeportivoDAO extends BaseDAO{
    
    public void insertarEvento(EventoDeportivo vo) throws DAOExcepcion {
		System.out.println("EvetoDeportivoDAO: insertar(EvetoDeportivo vo)");
		String query = "INSERT INTO tb_eventodeportivo(nombre, premio,cantidadEquipos,fechainscripcion,idusuario) VALUES (?,?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, vo.getNombre());
			stmt.setString(2, vo.getPremio());
                        stmt.setInt(3, vo.getCantidadEquipos());
                        stmt.setString(4, vo.getFechaInscripcion().toString());
                        stmt.setInt(5, vo.getId());
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo Insertar el Evento Deportivo");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
	}
    
    public EventoDeportivo obtenerNombre(String nombre) throws DAOExcepcion {
		System.out.println("EventoDeportivo Dao: obtenerNombre(String nombre)");
		EventoDeportivo vo = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String query = "select nombre from tb_EventoDeportivo where nombre=?";
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setString(1, nombre);
			rs = stmt.executeQuery();
			if (rs.next()) {
                            vo= new EventoDeportivo();
				vo.setNombre(rs.getString(1));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarResultSet(rs);
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
		return vo;
	}
    
    public List<EventoDeportivo> listar() throws DAOExcepcion {
        System.out.println("LocalDAO: listar(String idUsuario)");
        List<EventoDeportivo> lista = new ArrayList<EventoDeportivo>();
        EventoDeportivo vo = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String query = "select ideventodeportivo,nombre from tb_EventoDeportivo";
            con = ConexionBD.obtenerConexion();
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                vo = new EventoDeportivo();
                vo.setId(rs.getInt(1));
                vo.setNombre(rs.getString(2));
                lista.add(vo);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new DAOExcepcion(e.getMessage());
        } finally {
            this.cerrarResultSet(rs);
            this.cerrarStatement(stmt);
            this.cerrarConexion(con);
        }
        return lista;
    }
    
}
