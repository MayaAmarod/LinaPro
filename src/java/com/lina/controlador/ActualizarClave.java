package com.lina.controlador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.lina.controlador.PropiedadesCorreo;
import com.lina.modelo.UsuarioDAO;
import com.lina.vo.PersonasVO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author spier
 */
@WebServlet(urlPatterns = {"/ActualizarC"})
public class ActualizarClave extends HttpServlet {

    UsuarioDAO usuarioDAO = new UsuarioDAO();
    String mensajeError = "";
    String Pcorreo, Pdocumento, Pusuario, Pcontraseña;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PersonasVO personaVO = new PersonasVO();
        Pcontraseña = request.getParameter("textClaveR");

        UsuarioDAO usuDAO = new UsuarioDAO();

        ArrayList<PersonasVO> listaUsuarios = usuDAO.listarC(Pcorreo, Pdocumento);
        for (int i = 0; i < listaUsuarios.size(); i++) {
            personaVO = listaUsuarios.get(i);            
            Pdocumento = personaVO.getPdocumento();
            Pcorreo = personaVO.getPcorreo();
        }

        try (PrintWriter out = response.getWriter()) {

            Pcontraseña = usuarioDAO.cifrarClave(Pcontraseña.trim());
            boolean actualizado = usuarioDAO.actualizarClave(Pcontraseña, Pdocumento, Pcorreo);
            if (actualizado) {
                request.setAttribute("mensajeExito", "¡Contraseña actualizada exitosamente!");
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            } else {
                request.setAttribute("mensajeError", "¡Error al actualizar contraseña, vuelve a intentarlo!");
                request.getRequestDispatcher("confirmarClave.jsp").forward(request, response);
            }

        }

    }
}
