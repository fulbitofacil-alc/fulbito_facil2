/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import excepcion.DAOExcepcion;
import excepcion.NegocioExcepcion;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.*;
import negocio.AlquilerCanchaNegocio;
import negocio.CanchaNegocio;
import negocio.LocalNegocio;
import negocio.*;

/**
 *
 */
//--------------------------------------------------------------
public class AlquilerCanchaServlet extends HttpServlet {

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

        System.out.println("Ingreso a CanchaServlet");

        String metodo = req.getParameter("metodo");

        if (metodo == null || metodo.length() == 0) {
            Usuario usuario = (Usuario) req.getSession().getAttribute("sesionUsuario");

            List<Cancha> listadoCancha = new ArrayList<Cancha>();

            try {
                //Obtener locales del dueño
                //listadoLocal = new LocalNegocio().listar(usuario.getId());
                //listadoCancha = new  Cancha().l
            } catch (Exception ex) {
            }
            req.getSession().setAttribute("listadoCancha", listadoCancha);
            req.setAttribute("Alquilercancha", new AlquilerCancha());

            req.getRequestDispatcher("AlquilerCancha.jsp").forward(req, resp);
        } else if (metodo.equals("registrar")) {
            AlquilerCancha alquilercancha = new AlquilerCancha();

            //Obtener atributos de la cancha
            String canchaFulbito = req.getParameter("CanchaFulbito");
            String fecha = req.getParameter("fecha");
            String HoraInicio = req.getParameter("HoraInicio");
            String HoraFin = req.getParameter("HoraFin");

            try {
                //cancha.setLocal(new Local(Integer.valueOf(local)));
                //alquilercancha.setCancha(new Cancha(Integer.valueOf(Cancha)));
            } catch (Exception ex) {
            }

            alquilercancha.setFecha(fecha);
            alquilercancha.setHoraInicio(HoraInicio);
            alquilercancha.setHoraFin(HoraFin);


            try {
                //Registrar Alquiler de Cancha 
                new AlquilerCanchaNegocio().insertar(alquilercancha);

                req.setAttribute("mensaje", "registro exitoso");
                req.getRequestDispatcher("home.jsp").forward(req, resp);
            } catch (NegocioExcepcion ex) {
                req.setAttribute("alquilercancha", alquilercancha);
                req.setAttribute("mensaje", ex.getMessage());
                req.getRequestDispatcher("home.jsp").forward(req, resp);
            } catch (Exception ex) {
                ex.printStackTrace();
                req.setAttribute("alquilercancha", alquilercancha);
                req.setAttribute("mensaje", "error en registro");
                req.getRequestDispatcher("home.jsp").forward(req, resp);
            }

        }

    }
}
