/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import excepcion.DAOExcepcion;
import negocio.EventoDeportivoNegocio;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author operador
 */
public class EventoDeportivoTest {
    
    @Test
	public void insertarEventoDeportivoTest(){

		EventoDeportivoNegocio neg = new EventoDeportivoNegocio();
		try {
			neg.insertarEventoDeportivo("Campeonato Relampago7", "Juego de Camisetas del Barcelona",6,"2012-02-01 00:00:00",1);
		} catch (DAOExcepcion e) {
			fail("No se insertó el evento : " + e.getMessage());
		}
	}
    @Test
    public void NombreNoRepetidoTest(){

		EventoDeportivoNegocio neg = new EventoDeportivoNegocio();
		try {
			neg.insertarEventoDeportivo("Campeonato Relampago7", "Juego de Camisetas del Barcelona",6,"2012-02-01 00:00:00",1);
		} catch (DAOExcepcion e) {
			fail("No se insertó el evento : " + e.getMessage());
		}
	}
}
