/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Dueño;
import modelo.Local;
import negocio.LocalNegocio;

/**
 *
 * @author operador
 */
public class LocalServlet extends HttpServlet {

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
        Dueño dueño = (Dueño) req.getSession().getAttribute("sesionUsuario");

        //Obtener atributos de la cancha
        String nombre = req.getParameter("nombre");
        String direccion = req.getParameter("direccion");
        String distrito = req.getParameter("distrito");
        String dire_google = req.getParameter("dire_google");
        String telefono = req.getParameter("telefono");

        try {
            //Registrar Local
            Local local = new Local();

            local.setNombre(nombre);
            local.setDireccion(direccion);
            local.setDistritoId(Integer.valueOf(distrito));
            local.setTelefono(telefono);
            local.setDueño(dueño);

            new LocalNegocio().insertar(local);
            req.setAttribute("mensaje", "registro exitoso");
            req.getRequestDispatcher("home.jsp").forward(req, resp);
        } catch (Exception ex) {
            ex.printStackTrace();
            req.setAttribute("mensaje", "error en registro");
            req.getRequestDispatcher("local.jsp").forward(req, resp);
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
