/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import excepcion.NegocioExcepcion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Album;
import negocio.AlbumNegocio;

/**
 *
 * @author FERNANDO
 */
public class AlbumServlet extends HttpServlet {

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

        Album evento = new Album();

        //Obtener atributos de la cancha
        String fecha = req.getParameter("txtnombre");
        String nombre = req.getParameter("txtcomentario");
        String premio = req.getParameter("txtpremio");
        int IdEventoDeportivo = Integer.parseInt(req.getParameter("cbo"));
        try {
            //Registrar Evento Deportivo
            new AlbumNegocio().insertarAlbum(IdEventoDeportivo, nombre, premio, premio);
            req.setAttribute("mensaje", "registro exitoso");
            //req.getRequestDispatcher("home.jsp").forward(req, resp);
        } catch (Exception ex) {
            req.setAttribute("evento", evento);
            req.setAttribute("mensaje", ex.getMessage());
            req.getRequestDispatcher("futbitofacil.jsp").forward(req, resp);
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
