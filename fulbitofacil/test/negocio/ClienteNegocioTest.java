/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import modelo.Cliente;
import excepcion.DAOExcepcion;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Francisco
 */
public class ClienteNegocioTest {

    @Test
    public void testInsertar() {
        System.out.println("Insertar");
        ClienteNegocio instance = new ClienteNegocio();
        Cliente cliente = new Cliente();
        cliente.setCorreo("franciscod@gmail.com");
        cliente.setClave("prueba");
        cliente.setNombre("Rauld");
        cliente.setApellidoPaterno("Diazd");
        cliente.setApellidoMaterno("Diazd");
        cliente.setSexo('M');
        cliente.setDireccion("tulipanes 123");
        cliente.setDistritoId(1);
        cliente.setFechaNacimiento("1999-12-12");
        cliente.setCelular("999999999");
        //usuario.setTipo(2);
        cliente.setEstado(4);
        try {
            instance.insertar(cliente);
        } catch (DAOExcepcion e) {
            fail("Falló: " + e.getMessage());
        }
    }
}
