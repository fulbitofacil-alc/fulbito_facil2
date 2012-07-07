/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cliente;
import modelo.Usuario;
import negocio.ClienteNegocio;
import negocio.UsuarioNegocio;

/**
 *
 * @author Francisco
 */
public class RegistrarClienteServlet extends HttpServlet {

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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<String> errores = new ArrayList<String>();


        String nombre = request.getParameter("nombre");
        String paterno = request.getParameter("paterno");
        String materno = request.getParameter("materno");
        String email = request.getParameter("email");
        String sexo = request.getParameter("sexo");
        String dni = request.getParameter("dni");
        String direccion = request.getParameter("direccion");
        String distrito = request.getParameter("distrito");
        String fnac = request.getParameter("fnac");
        String celular = request.getParameter("celular");
        String tipo = request.getParameter("tipo");
        String estado = request.getParameter("estado");
        String clave1 = request.getParameter("clave1");
        String clave2 = request.getParameter("clave2");

        if (nombre.isEmpty()) {
            errores.add("Debe de ingresar un nombre.");
        }

        if (paterno.isEmpty()) {
            errores.add("Debe de ingresar un Apellido paterno.");
        }

        if (materno.isEmpty()) {
            errores.add("Debe de ingresar un Apellido materno.");
        }

        if (email.isEmpty()) {
            errores.add("Debe de ingresar un correo.");
        }

        if (dni.isEmpty()) {
            errores.add("Debe de ingresar un correo.");
        }

        if (direccion.isEmpty()) {
            errores.add("Debe de ingresar un correo.");
        }

        if (clave1.equals(clave2)) {
        } else {
            errores.add("Las contrasenas no coinciden.");
        }

        if (dni.isEmpty()) {
            errores.add("Debe de ingresar un correo.");
        }

        if (errores.isEmpty()) {
            ClienteNegocio un = new ClienteNegocio();
            try {
                Cliente vo = new Cliente();
                vo.setNombre(nombre);
                vo.setApellidoPaterno(paterno);
                vo.setApellidoMaterno(materno);
                vo.setCorreo(email);
                vo.setSexo(sexo.charAt(0));
                vo.setDni(dni);
                vo.setDireccion(direccion);
                vo.setDistritoId(Integer.valueOf(distrito));
                vo.setFechaNacimiento(fnac);
                vo.setCelular(celular);
                vo.setClave(clave1);
                vo.setEstado(Integer.valueOf(1));
                un.insertar(vo);

                RequestDispatcher vista = request.getRequestDispatcher("login.jsp");
                vista.forward(request, response);

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Fallo al registrar");
                errores.add("Hubo un error en el registro del evento");
                request.setAttribute("errores", errores);
                RequestDispatcher vista = request.getRequestDispatcher("RegistrarCliente.jsp");
                vista.forward(request, response);
            }
        } else {
            System.out.println("Fallo al registrar");
            request.setAttribute("errores", errores);
            RequestDispatcher vista = request.getRequestDispatcher("RegistrarCliente.jsp");
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
