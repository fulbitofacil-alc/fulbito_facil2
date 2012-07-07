/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Dueño;
import negocio.DueñoNegocio;

/**
 *
 * @author operador
 */
public class DuenoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String paterno = request.getParameter("paterno");
        String materno = request.getParameter("materno");
        String sexo = request.getParameter("sexo");
        String dni = request.getParameter("dni");
        String direccion = request.getParameter("direccion");
        String distrito = request.getParameter("distrito");
        String email = request.getParameter("email");
        String clave1 = request.getParameter("clave1");
        String fnac = request.getParameter("fnac");
        String celular = request.getParameter("celular");

        DueñoNegocio un = new DueñoNegocio();

        try {
            Dueño vo = new Dueño();
            vo.setNombre(nombre);
            vo.setApellidoPaterno(paterno);
            vo.setApellidoMaterno(materno);
            vo.setSexo(sexo.charAt(0));
            vo.setDni(dni);
            vo.setDireccion(direccion);
            vo.setDistritoId(Integer.valueOf(distrito));
            vo.setCorreo(email);
            vo.setClave(clave1);
            vo.setFechaNacimiento(fnac);
            vo.setCelular(celular);
            vo.setTipo(Integer.valueOf(1));
            vo.setEstado(Integer.valueOf(1));
            un.insertar(vo);

            RequestDispatcher vista = request.getRequestDispatcher("login.jsp");
            vista.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "error en registro");
            RequestDispatcher vista = request.getRequestDispatcher("RegistroDueno.jsp");
            vista.forward(request, response);
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
