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
import modelo.Cancha;
import modelo.HorarioCancha;
import modelo.Local;
import modelo.Usuario;
import negocio.CanchaNegocio;
import negocio.LocalNegocio;

/**
 *
 * @author operador
 */
public class CanchaServlet extends HttpServlet {

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
            List<Local> listadoLocal = new ArrayList<Local>();
            try {
                //Obtener locales del dueño
                listadoLocal = new LocalNegocio().listar(usuario.getId());
            } catch (Exception ex) {
            }
            req.getSession().setAttribute("listadoLocal", listadoLocal);
            req.setAttribute("cancha", new Cancha());

            req.getRequestDispatcher("cancha.jsp").forward(req, resp);
        } else if (metodo.equals("registrar")) {
            Cancha cancha = new Cancha();

            //Obtener atributos de la cancha
            String local = req.getParameter("local");
            String nombre = req.getParameter("nombre");
            String tarifaDiurna = req.getParameter("tarifaDiurna");
            String tarifaNocturna = req.getParameter("tarifaNocturna");

            try {
                cancha.setLocal(new Local(Integer.valueOf(local)));
            } catch (Exception ex) {
            }

            cancha.setNombre(nombre);

            try {
                cancha.setTarifaDiurna(Double.parseDouble(tarifaDiurna));
            } catch (Exception ex) {
            }
            try {
                cancha.setTarifaNocturna(Double.parseDouble(tarifaNocturna));
            } catch (Exception ex) {
            }

            //Obtener horario
            HorarioCancha hc = null;
            List<HorarioCancha> listado = new ArrayList<HorarioCancha>();
            String[] horario = req.getParameterValues("horario");
            String[] arr = null;
            if (horario != null) {
                for (String dia_hora : horario) {
                    arr = dia_hora.split("_");
                    hc = new HorarioCancha();
                    hc.setDia(arr[0]);
                    hc.setHora(arr[1]);
                    listado.add(hc);
                }
            }

            try {
                //Registrar Cancha y Horario
                new CanchaNegocio().insertar(cancha, listado);
                req.setAttribute("mensaje", "registro exitoso");
                req.getRequestDispatcher("home.jsp").forward(req, resp);
            } catch (NegocioExcepcion ex) {
                req.setAttribute("cancha", cancha);
                req.setAttribute("horario", horario);
                req.setAttribute("error", ex.getMessage());
                req.getRequestDispatcher("cancha.jsp").forward(req, resp);
            } catch (Exception ex) {
                ex.printStackTrace();
                req.setAttribute("cancha", cancha);
                req.setAttribute("horario", horario);
                req.setAttribute("error", "error en registro");
                req.getRequestDispatcher("cancha.jsp").forward(req, resp);
            }

        } else if (metodo.equals("buscar")) {
            //Obtener atributos de busqueda
            String distrito = req.getParameter("distrito");
            String dia = req.getParameter("dia");
            String hora = req.getParameter("hora");
            List<HorarioCancha> listado = new ArrayList<HorarioCancha>();
            try {
                //Obtener locales del dueño
                listado = new CanchaNegocio().listar(null, (distrito != null && !distrito.equals("")) ? Integer.parseInt(distrito) : null, dia, (hora != null && !hora.equals("")) ? hora : null);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            req.setAttribute("listado", listado);
            req.setAttribute("distrito", distrito);
            req.setAttribute("dia", dia);
            req.setAttribute("hora", hora);
            req.getRequestDispatcher("BuscarCancha.jsp").forward(req, resp);
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
