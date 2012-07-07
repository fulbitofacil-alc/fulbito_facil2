/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import modelo.Local;
import modelo.*;
import excepcion.DAOExcepcion;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cdiaz
 */
public class PromocionNegocioTest {
    
    @Test
    public void testInsertar() throws DAOExcepcion {
        System.out.println("Insertar");
        PromocionNegocio instance = new PromocionNegocio();
        Promocion promocion = new Promocion();
        promocion.setNombre("Promocion Nueva2");
        
        promocion.setNombre("Promocion 2");
        promocion.setDescripcion("Descripcion 2");
        promocion.setPrecio(45.00);
        
        instance.insertar(promocion);
    }
}
