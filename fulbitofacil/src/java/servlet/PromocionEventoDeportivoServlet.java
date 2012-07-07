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
import modelo.Promocion;
import modelo.Usuario;
import negocio.EventoDeportivoNegocio;
import negocio.PromocionNegocio;

/**
 *
 * @author operador
 */
public class PromocionEventoDeportivoServlet extends HttpServlet {

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
            List<Promocion> listadoPromociones = new ArrayList<Promocion>();
            try {
                //Obtener locales del dueño
                //listadoEventos = new EventoDeportivoNegocio().listar();
            } catch (Exception ex) {
            }
            req.getSession().setAttribute("listadoPromociones", listadoPromociones);
            //req.setAttribute("evento", new Cancha());

            req.getRequestDispatcher("home.jsp").forward(req, resp);

        } else {
            Promocion promo = new Promocion();

            //Obtener atributos de la cancha
            String nombrePromocion = req.getParameter("NombrePromocion");
            String descripcionPromocion = req.getParameter("DescripcionPromocion");
            String PrecioPromocion = req.getParameter("PrecioPromocion");


            promo.setNombre(nombrePromocion);
            promo.setDescripcion(descripcionPromocion);

            try {

                promo.setPrecio(Double.parseDouble(PrecioPromocion));

            } catch (Exception ex) {
            }



            try {
                //Registrar Evento Deportivo
                new PromocionNegocio().insertar(promo);
                req.setAttribute("mensaje", "registro exitoso");

                //req.getRequestDispatcher("home.jsp").forward(req, resp);
            } catch (Exception ex) {
                ex.printStackTrace();
                req.setAttribute("promo", promo);
                req.setAttribute("mensaje", ex.getMessage());
                req.getRequestDispatcher("futbitofacil1.jsp").forward(req, resp);
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
