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
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nidia
 */
@WebServlet(urlPatterns = {"/EnvioCorreo"})
public class EnvioCorreo extends HttpServlet {

    UsuarioDAO usuarioDAO = new UsuarioDAO();
    String mensajeError = "";
    String Pcorreo, Pdocumento, Pusuario;

    private String host;
    private String puerto;
    private String usuario;
    private String clave;

    public void init() {

        ServletContext contexto = getServletContext();
        host = contexto.getInitParameter("host");
        puerto = contexto.getInitParameter("puerto");
        usuario = contexto.getInitParameter("usuario");
        clave = contexto.getInitParameter("clave");
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
        PersonasVO personaVO = new PersonasVO();
        personaVO.setPcorreo(request.getParameter("textCorreo"));
        personaVO.setPdocumento(request.getParameter("textDocumento"));

        Pcorreo = personaVO.getPcorreo();
        Pdocumento = personaVO.getPdocumento();
        
        Pusuario = personaVO.getPusuario();
        
        String receptor = Pcorreo;//-> Receptor estaba con "s"
        String asunto = "Recuperación de Contraseña - LINA";
        String contenido = "\n"
                         + " Señor(a): "+Pusuario+"\n"
                         + " E-mail: "+Pcorreo+"\n\n\n"
                         + " Para poder realizar el cambio de contraseña por favor ingresar en el siguiente link:\n"
                         + " Recuperación de Contraseña: http://localhost:8080/LinaPro/confirmarClave.jsp \n\n\n"
                         + " Cordialmente.\n"
                         + " LINA - GroupCol";

        String mensajeE = "";

        try (PrintWriter out = response.getWriter()) {
            //Form registro

            boolean verificador = usuarioDAO.verificarCorreo(Pcorreo, Pdocumento);
            if (verificador) {
                try {
                    PropiedadesCorreo.envioCorreo(host, puerto, usuario, clave, receptor, asunto, contenido);
                    mensajeE = "Verificar por favor el correo electronico";
                } catch (Exception e) {
                    e.printStackTrace();
                    mensajeE = "Error al enviar el clave de seguridad, intentelo mas tarde ";
                    System.out.println("Error" + e.toString());
                } finally {
                    request.setAttribute("mensajeExito", mensajeE);
                    getServletContext().getRequestDispatcher("/recuperarClave.jsp").forward(request, response);
                }
                request.getRequestDispatcher("recuperarClave.jsp").forward(request, response);
            } else {
                request.setAttribute("mensajeError", "¡Tus datos no coinciden con nuestros registros. Verifica e inténtalo de nuevo.!");
                request.getRequestDispatcher("recuperarClave.jsp").forward(request, response);
            }

        }

    }
}
