/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import modelo.Album;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import util.ConexionBD;



import excepcion.DAOExcepcion;

/**
 *
 * @author Fernando Llanos
 */
public class AlbumDAO extends BaseDAO{

    public void insertarEvento(Album vo) throws DAOExcepcion {
		System.out.println("Album: insertar(Album vo)");

		String query = "INSERT INTO tb_album(idEventoDeportivo,nombre,comentario,rutaFotos)VALUES(?,?,?,?)";
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = ConexionBD.obtenerConexion();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, vo.getIdEventoDeportivo());
			stmt.setString(2, vo.getNombre());
                        stmt.setString(3, vo.getComentario());
                        stmt.setString(4, vo.getRutaFotos());
			int i = stmt.executeUpdate();
			if (i != 1) {
				throw new SQLException("No se pudo Insertar el Album");
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			throw new DAOExcepcion(e.getMessage());
		} finally {
			this.cerrarStatement(stmt);
			this.cerrarConexion(con);
		}
	}
}
