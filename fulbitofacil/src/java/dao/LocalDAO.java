/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import excepcion.DAOExcepcion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Local;
import util.ConexionBD;

/**
 *
 * @author falfaro
 */
//private Integer id;
//    private String nombre;
//    private Integer distritoId;
//    private String direccion;
//    private String telefono;
//    private Dueño dueño;
public class LocalDAO extends BaseDAO{

    public void insertar(Local vo) throws DAOExcepcion {
        System.out.println("LocalDAO: insertar(Local vo)");
        String query = "INSERT INTO Tb_Local(nombre,distrito,direccion,telefono,idUsuario) VALUES (?,?,?,?,?)";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConexionBD.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setString(1, vo.getNombre());
            stmt.setInt(2, vo.getDistritoId());
            stmt.setString(3, vo.getDireccion());
            stmt.setString(4, vo.getTelefono());
            stmt.setInt(5, vo.getDueño().getId());
            int i = stmt.executeUpdate();
            if (i != 1) {
                throw new SQLException("No se pudo insertar");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new DAOExcepcion(e.getMessage());
        } finally {
            this.cerrarStatement(stmt);
            this.cerrarConexion(con);
        }
    }

//    Mensaje de error si el nombre descriptivo del local ya existe para ese dueño.
    public Local obtener(String nombre, Integer usuario) throws DAOExcepcion {
        System.out.println("LocalDAO: obtener(String nombre)");
        Local vo = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String query = "select idLocal,nombre,distrito,direccion,telefono from Tb_Local where nombre=? and idUsuario=?";
            con = ConexionBD.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setString(1, nombre);
            stmt.setInt(2, usuario);
            rs = stmt.executeQuery();
            if (rs.next()) {
                vo = new Local();
                vo.setId(rs.getInt(1));
                vo.setNombre(rs.getString(2));
                vo.setDistritoId(rs.getInt(3));
                vo.setDireccion(rs.getString(4));
                vo.setTelefono(rs.getString(5));
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
    
    public List<Local> listar(Integer idUsuario) throws DAOExcepcion {
        System.out.println("LocalDAO: listar(String idUsuario)");
        List<Local> lista = new ArrayList<Local>();
        Local vo = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String query = "select idLocal,nombre,distrito,direccion,telefono from Tb_Local where idUsuario=?";
            con = ConexionBD.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setInt(1, idUsuario);
            rs = stmt.executeQuery();
            while (rs.next()) {
                vo = new Local();
                vo.setId(rs.getInt(1));
                vo.setNombre(rs.getString(2));
                vo.setDistritoId(rs.getInt(3));
                vo.setDireccion(rs.getString(4));
                vo.setTelefono(rs.getString(5));
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
