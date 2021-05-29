package com.lina.controlador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.lina.modelo.UsuarioDAO;
import com.lina.vo.PersonasVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author spier
 */
@WebServlet(urlPatterns = {"/Registrar"})
public class Registrarse extends HttpServlet {

    int tipoUsuarioEmpleado = 2;//por defecto se crean los usuarios como tipo 2 (empleado)
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    String mensajeError = "";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    String Pusuario, Pcorreo, Ptipodocumento, Pdocumento, Pdireccion, Pcelular, Pcontraseña;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        PersonasVO personaVO = new PersonasVO();
        
        
        try (PrintWriter out = response.getWriter()) {
            //Form registro
            personaVO.setPusuario(request.getParameter("textNombre"));
            personaVO.setPcontraseña(request.getParameter("textClaveR"));
            personaVO.setPcorreo(request.getParameter("textCorreo"));
            personaVO.setPdocumento(request.getParameter("textDocumento"));
            personaVO.setPtipodocumento(request.getParameter("textTipoDocumento"));
            personaVO.setPdireccion(request.getParameter("textDireccion"));
            personaVO.setPcelular(request.getParameter("textCelular"));
            
            Pusuario = personaVO.getPusuario();
            Pcontraseña = personaVO.getPcontraseña();
            Pcorreo = personaVO.getPcorreo();
            Pdocumento = personaVO.getPdocumento();
            Ptipodocumento = personaVO.getPtipodocumento();
            Pdireccion = personaVO.getPdireccion();
            Pcelular = personaVO.getPcelular();
              
            
            if(!validacionesSonCorrectas()){
                //mensajeError="validaciones incorrectas";
                 request.setAttribute("mensajeError", "¡Validaciones incorrectas!");
                 request.getRequestDispatcher("RegistroUsuario.jsp").forward(request, response);
                 return;
            }

            boolean existeUsuario = usuarioDAO.exisisteUsuario(Pcorreo);
            if (existeUsuario) {
                //mensajeError="usuario con el mismo correo ya existe";
                request.setAttribute("mensajeError", "¡Ya existe un usuario con el mismo correo!");
                request.getRequestDispatcher("RegistroUsuario.jsp").forward(request, response);
                return;
            }


            Pcontraseña = usuarioDAO.cifrarClave(Pcontraseña.trim());

            boolean registroExitoso = usuarioDAO.registrarUsuario(Pusuario, Pcontraseña, Pcorreo, Pdocumento, tipoUsuarioEmpleado, Integer.parseInt(Ptipodocumento), Pdireccion, Pcelular);
            if (registroExitoso) {
                request.setAttribute("mensajeExito", "¡Registro exitoso!");
                request.getRequestDispatcher("RegistroUsuario.jsp").forward(request, response);
            } else {
                //TODO colocar el error apropiado segun sea el caso
                 //mensajeError="Error al insertar usuario en base de datos";
                request.setAttribute("mensajeError", "¡Error al insertar usuario en base de datos!");
                request.getRequestDispatcher("RegistroUsuario.jsp").forward(request, response);
            }
            
            
            
            
            
            
            
        }
    }

    /**
     * realiza todas las validaciones antes de crear el nuevo usuario
     *
     * @param correo
     * @return
     */
    private boolean validacionesSonCorrectas() {
        
        //TODO realizar validaciones de correo 
      return true;
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