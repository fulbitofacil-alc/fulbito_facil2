/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import excepcion.DAOExcepcion;
import modelo.Usuario;
import org.junit.Test;
import static org.junit.Assert.*;



/**
 *
 * @author cdiaz
 */
public class SeguridadNegocioTest {

    @Test
    public void testObtener() {
        System.out.println("obtener");
        String correo = "prueba@gmail.com";
        String clave = "prueba";
        SeguridadNegocio instance = SeguridadNegocio.getInstance();
        try {
            Usuario result = instance.obtener(correo, clave);
            assertNotNull(result);
            System.out.println("Nombre:" + result.getNombre());
            System.out.println("Apellido Paterno:" + result.getApellidoPaterno());
            System.out.println("Apellido Materno:" + result.getApellidoMaterno());

        } catch (DAOExcepcion e) {
            fail("Falló: " + e.getMessage());
        }
    }
}
