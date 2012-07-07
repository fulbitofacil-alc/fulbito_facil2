/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import modelo.Dueño;
import excepcion.DAOExcepcion;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Francisco
 */
public class DueñoNegocioTest {

    @Test
    public void testInsertar() {
        System.out.println("Insertar");
        DueñoNegocio instance = new DueñoNegocio();
        Dueño dueño = new Dueño();
        dueño.setCorreo("cdiaz@gmail.com");
        dueño.setClave("cidaz");
        dueño.setNombre("Carlos");
        dueño.setApellidoPaterno("Diaz");
        dueño.setApellidoMaterno("Oliva");
        dueño.setSexo('M');
        dueño.setDni("145");
        dueño.setDireccion("tulipanes 123");
        dueño.setDistritoId(1);
        dueño.setFechaNacimiento("1999-12-12");
        dueño.setCelular("999999999");
        //usuario.setTipo(1);
        dueño.setEstado(4);
        try {
            instance.insertar(dueño);
        } catch (DAOExcepcion e) {
            fail("Falló: " + e.getMessage());
        }
    }
}
