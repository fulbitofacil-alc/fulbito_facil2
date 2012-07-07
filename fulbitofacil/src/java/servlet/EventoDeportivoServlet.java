/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import excepcion.NegocioExcepcion;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.EventoDeportivo;
import modelo.Usuario;
import negocio.EventoDeportivoNegocio;

/**
 *
 * @author operador
 */
public class EventoDeportivoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String metodo = req.getParameter("metodo");
        Usuario usuario = (Usuario) req.getSession().getAttribute("sesionUsuario");

        if (metodo == null || metodo.length() == 0) {
            List<EventoDeportivo> listadoEventos = new ArrayList<EventoDeportivo>();
            try {
                //Obtener Eventos del dueño
                listadoEventos = new EventoDeportivoNegocio().listar();
            } catch (Exception ex) {
            }
            req.getSession().setAttribute("listadoEventos", listadoEventos);
            //req.setAttribute("evento", new Cancha());

            req.getRequestDispatcher("home.jsp").forward(req, resp);

        } else {
            EventoDeportivo evento = new EventoDeportivo();

            //Obtener atributos de la cancha
            String fecha = req.getParameter("txtfecha");
            String nombre = req.getParameter("txtnombre");
            String premio = req.getParameter("txtpremio");
            int cantidad = Integer.parseInt(req.getParameter("txtcantidad"));


            evento.setFechaInscripcion(fecha);

            evento.setNombre(nombre);

            evento.setPremio(premio);
            try {
                //Registrar Evento Deportivo
                new EventoDeportivoNegocio().insertarEventoDeportivo(nombre, premio, cantidad, fecha, 1);
                req.setAttribute("mensaje", "registro exitoso");
                //req.getRequestDispatcher("home.jsp").forward(req, resp);
            } catch (Exception ex) {
                req.setAttribute("evento", evento);
                req.setAttribute("mensaje", ex.getMessage());
                req.getRequestDispatcher("futbitofacil.jsp").forward(req, resp);
            }
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
