/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import excepcion.DAOExcepcion;
import modelo.Album;
import negocio.AlbumNegocio;

/**
 *
 * @author Fernando Llanos
 */
public class AlbumNegocioTest {

    public AlbumNegocioTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
	public void insertarAlbumTest() throws Exception{

		AlbumNegocio neg = new AlbumNegocio();
                int IdEventoDeportivo=1;
                String nombre="Fotos 2011";
                String comentario="bacano";
                String rutafotos="C:\\Album\\Enero2012\\";
		try {
			neg.insertarAlbum(IdEventoDeportivo,nombre,comentario,rutafotos);
                        System.out.println("Se Registro Correctamente.");
		} catch (DAOExcepcion e) {
			fail("No se insertó el Album : " + e.getMessage());
		}
	}
    @Test
    public void ValidarDatosDeEntradaAlbumTest() throws Exception{

		AlbumNegocio neg = new AlbumNegocio();
                int IdEventoDeportivo=1;
                String nombre="Fotos 2011";
                String comentario="bacano";
                String rutafotos="C:\\Album\\Enero2012\\";
		try {
			neg.insertarAlbum(IdEventoDeportivo,nombre,comentario,rutafotos);
		} catch (DAOExcepcion e) {
			fail("Error Al Ingresar Datos : " + e.getMessage());
		}
	}

}