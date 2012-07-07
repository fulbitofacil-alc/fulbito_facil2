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
import modelo.Promocion;
import modelo.Promocion;
import util.ConexionBD;

/**
 *
 * @author juan
 */
public class PromocionDAO extends BaseDAO {

    public void insertar(Promocion vo) throws DAOExcepcion {
        System.out.println("PromocionDAO: insertar(Promocion vo)");
        String query = "INSERT INTO Tb_Promocion(nombre,descripcion,precio) VALUES (?,?,?)";
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConexionBD.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setString(1, vo.getNombre());
            stmt.setString(2, vo.getDescripcion());
            stmt.setDouble(3, vo.getPrecio());
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

    public Promocion obtener(String nombre) throws DAOExcepcion {
        System.out.println("PromocionDAO: obtener(String nombre)");
        Promocion vo = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String query = "select idPromocion,nombre,descripcion,precio from Tb_Promocion where nombre=?";
            con = ConexionBD.obtenerConexion();
            stmt = con.prepareStatement(query);
            stmt.setString(1, nombre);
            rs = stmt.executeQuery();
            if (rs.next()) {
                vo = new Promocion();
                vo.setId(rs.getInt(1));
                vo.setNombre(rs.getString(2));
                vo.setDescripcion(rs.getString(3));
                vo.setPrecio(rs.getDouble(4));
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
}
