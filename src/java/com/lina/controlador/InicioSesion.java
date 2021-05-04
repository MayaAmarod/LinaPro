package com.lina.controlador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.lina.modelo.UsuarioDAO;
import com.lina.vo.UsuariosVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sun.awt.RequestFocusController;

/**
 *
 * @author spier
 */
@WebServlet(urlPatterns = {"/InicioSesion"})
public class InicioSesion extends HttpServlet {

    //Prueba commit 1
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    //Declaracion de variables
    private String Ucorreo = "", Uclave = "";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {//Hacerlo post

        //Enviar datos recibidos de la vista al VO
        UsuariosVO usuarioVO = new UsuariosVO();
        usuarioVO.setUcorreo(request.getParameter("textcorreo"));
        usuarioVO.setUclave(request.getParameter("textClave"));

        //Recibir valor de las variables del VO
        Ucorreo = usuarioVO.getUcorreo();
        Uclave = usuarioVO.getUclave();

        /*Quitar y arreglar
        String correo = request.getParameter("textcorreo"); ->prueba
        String clave = request.getParameter("textClave");        
        //->Temporal*/
        
        //Instanciar DAO para realizar metodo de consulta e inicio de sesion
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        try (PrintWriter out = response.getWriter()) {

            //Todas las validaciones de campos
            
               //Metodo de encriptacion

                Uclave = usuarioDAO.cifrarClave(Uclave);
                //usuarioVO.setUclave(encryptUtil.cifrarClave(usuarioVO.getUclave())); ->prueba

                //Recibir los datos del VO para validar el metodo autenticacion
                //boolean loginCorrecto = usuarioDAO.autenticacion(usuarioVO); ->prueba
                boolean loginCorrecto = usuarioDAO.autenticacion(Ucorreo, Uclave);

                //Condicional de datos correctos para acceder a la pagina (Si todas las validaciones pasan)
                if (loginCorrecto) {
                    //Enviar mensaje a la vista (Datos correctos)  
                    
                    String mensajeU = request.getParameter("textcorreo");
                    request.getSession().setAttribute("Usuario", mensajeU);
                    request.setAttribute("mensajeExito", "");
                    request.setAttribute("MensajeU", "");
                    //Redireccionar al dashboard
                    request.getRequestDispatcher("LinaHome.jsp").forward(request, response);
                } else {
                    //Enviar mensaje a la vista (Datos incorrectos)
                    //request.setAttribute("error", "Invalid Username or Password"); ->prueba   
                    request.setAttribute("MensajeU", "¡Tus datos no coinciden con nuestros registros. Verifica e inténtalo de nuevo.!");
                    //Redireccionar a la misma pagina
                    request.getRequestDispatcher("Login.jsp").forward(request, response);
                }
         

        }

    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
        /*
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            //Form login
            String usuario = request.getParameter("textUsuario");
            String clave = request.getParameter("textClave");

            Consultas consulta = new Consultas();
            if (consulta.autenticacion(usuario, clave)) {
                response.sendRedirect("PagComercial.jsp");
            } else {
                //String mensaje = request.getParameter("textUsuario");     
                String prueba = " Error: Mensaje enviado";
                request.setAttribute("ValPrueba", prueba);
                response.sendRedirect("Login.jsp");
            }

        } */

    }

    /**
     * Handles the HTTP <code>POST</code> method.
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
