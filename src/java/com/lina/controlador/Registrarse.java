package com.lina.controlador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.lina.modelo.UsuarioDAO;
import com.lina.vo.PersonasVO;
import com.lina.vo.productoVO;
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
@WebServlet(name = "Registrarse", urlPatterns = {"/Registrar"})
public class Registrarse extends HttpServlet {

    //int tipoUsuarioEmpleado = 2;//por defecto se crean los usuarios como tipo 2 (empleado)
    int tipoEstado = 1;
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
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            
        String Pid_usuario, Pusuario, Pcorreo, Ptipodocumento, Pdocumento, Pdireccion,
            Pcelular, Pcontraseña, PtelefonoFijo, PtipoUsuario, Pid_estado;
        
        PersonasVO personaVO = new PersonasVO();
        int opcion = Integer.parseInt(request.getParameter("opcion")); //29 ej para enumerar o identificar las vistas  

        try (PrintWriter out = response.getWriter()) {
            //Form registro            
            Pid_usuario = request.getParameter("textid_usuario");
            Pusuario =request.getParameter("textNombre");
            Pdocumento = request.getParameter("textDocumento");
            Pcorreo = request.getParameter("textCorreo");
            Pdireccion = request.getParameter("textDireccion");            
            Pcontraseña = request.getParameter("textClaveR");
            PtelefonoFijo = request.getParameter("textFijo");
            Pcelular = request.getParameter("textCelular");
            PtipoUsuario = request.getParameter("textTipoUsuario");
            Ptipodocumento = request.getParameter("textTipoDocumento");
            Pid_estado = "1";            

            PersonasVO perVO = new PersonasVO(Pid_usuario, Pusuario, Pdocumento,Pcorreo,
                    Pdireccion,Pcontraseña,PtelefonoFijo, Pcelular, PtipoUsuario,Ptipodocumento, Pid_estado);
                    
                      
            UsuarioDAO usuDAO = new UsuarioDAO(perVO);

            switch (opcion) {
                //controlador recibe del DAO un verdadero o falso y responde a la vista   
                case 1: //Registrar
                    Pcontraseña = usuarioDAO.cifrarClave(Pcontraseña.trim());
                    if (!validacionesSonCorrectas()) {
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
                    boolean registroExitoso = usuarioDAO.registrarUsuario(Pusuario, Pcontraseña, Pcorreo, Pdocumento,
                            Integer.parseInt(PtipoUsuario), Integer.parseInt(Ptipodocumento), Pdireccion, PtelefonoFijo, Pcelular, tipoEstado);

                    if (registroExitoso) {
                        request.setAttribute("mensajeExito", "¡Registro exitoso!");
                        request.getRequestDispatcher("RegistroUsuario.jsp").forward(request, response);
                    } else {
                        //TODO colocar el error apropiado segun sea el caso
                        //mensajeError="Error al insertar usuario en base de datos";
                        request.setAttribute("mensajeError", "¡Error al insertar usuario en base de datos!");
                        request.getRequestDispatcher("RegistroUsuario.jsp").forward(request, response);
                    }
                    break;
                    
                case 2: //Actualizar
                    if (usuDAO.actualizarRegistro()) { //si el metodo es verdadero se envia mensaje
                        request.setAttribute("mensajeExito", "El usuario se actualizo correctamente");
                        request.getRequestDispatcher("ActualizarUsuario.jsp").forward(request, response);
                        //obtenga un atributo que se llama mensaje exito, (nombredelatributo, mensaje enviado)
                    } else {
                        request.setAttribute("mensajeError", "El usuario NO se actualizo correctamente");
                        request.getRequestDispatcher("ActualizarUsuario.jsp").forward(request, response);
                    }
                    break;
                case 3: //Metodo propio
                    personaVO = usuDAO.consultar_nombreUsuario(Pid_usuario); //se llena el objeto con la consulta que se hace en dao

                    if (personaVO != null) { //si retorna no nulo significa que si lleno 
                        request.setAttribute("Datos Consultados", personaVO); //el objeto se llama datos consultados, se envia VO lleno
                        request.getRequestDispatcher("RellenoUsuario.jsp").forward(request, response); //aqui va a llenar
                        //si va a actualizar luego de la consulta o solo ver
                    } else {
                        request.setAttribute("mensajeError", "El usuario NO existe");
                        request.getRequestDispatcher("RegistroUsuario.jsp").forward(request, response);                    }
                    
                    break;
                case 4: //Eliminar                   
                    if (usuDAO.Eliminar()) { //si el metodo es verdadero se envia mensaje
                        request.setAttribute("mensajeExito", "El usuario se elimino correctamente");
                        response.sendRedirect("eliminarUsuario.jsp");
                        //obtenga un atributo que se llama mensaje exito, (nombredelatributo, mensaje enviado)
                    } else {
                        request.setAttribute("mensajeError", "El usuario NO se elimino correctamente");
                        response.sendRedirect("eliminarUsuario.jsp");
                    }
                    break;
                //37 VISTAS WEB PAGES, Nuevo jsp  
                //38. nuevo java class categoriaVO, despues, para crear foraneas
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