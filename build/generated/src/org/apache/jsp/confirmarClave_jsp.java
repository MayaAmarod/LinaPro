package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class confirmarClave_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- definir que versión de HTML5 se usa para que el navegador interprete-->\r\n");
      out.write("<html lang=\"es-419\">\r\n");
      out.write("    <!-- definir idioma -->\r\n");
      out.write("    <head>\r\n");
      out.write("        <!-- informacion que lee el navegador y no muestra -->\r\n");
      out.write("        <title>\r\n");
      out.write("            Confirmar Contraseña\r\n");
      out.write("        </title>\r\n");
      out.write("        <!-- definit titulo -->\r\n");
      out.write("        <!-- metaetiquetas -->\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <!-- permite lectura de caracteres especiales -->\r\n");
      out.write("        <meta content=\"width=device-width, initial-scale=1, shrink-to-fit=no\" name=\"viewport\">\r\n");
      out.write("        <!-- realizar la identificacion de resolucion de los diapositivos -->\r\n");
      out.write("        <script type=\"text/javascript\" src=\"js/formulario.js\"></script> \r\n");
      out.write("        <link href=\"css/EstiloRec.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("        <!--enlazar hoja de estilo -->\r\n");
      out.write("        </link>\r\n");
      out.write("        </meta>\r\n");
      out.write("        </meta>\r\n");
      out.write("    </head>\r\n");
      out.write("</html>\r\n");
      out.write("<body oncopy=\"return false\" onpaste=\"return false\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <header>\r\n");
      out.write("        </header>\r\n");
      out.write("        <nav>\r\n");
      out.write("        </nav>\r\n");
      out.write("        <main>\r\n");
      out.write("            <div class=\"contenedor\">\r\n");
      out.write("                <!-- agrupar contenido en bloques -->\r\n");
      out.write("                <!-- contenedor Informacion -->\r\n");
      out.write("                <div class=\"ContendedorTexto\">\r\n");
      out.write("                    <div class=\"ContenedorDegrade\">\r\n");
      out.write("                        <div class=\"contenedorText\">\r\n");
      out.write("                            <a href=\"index.jsp\"> <img class=\"logo\" src=\"Imagen/LogoLina.svg\"></a>\r\n");
      out.write("                            <h1 class=\"TTitulo\">\r\n");
      out.write("                            </h1>\r\n");
      out.write("                            <p class=\"TDescripcion\">\r\n");
      out.write("                                <strong>\r\n");
      out.write("                                    Optimizar\r\n");
      out.write("                                </strong>\r\n");
      out.write("                                los procesos de tu empresa\r\n");
      out.write("                                <br>\r\n");
      out.write("                                <strong>\r\n");
      out.write("                                    Mejorar\r\n");
      out.write("                                </strong>\r\n");
      out.write("                                la productividad de tus empleados\r\n");
      out.write("                                <br>\r\n");
      out.write("                                <strong>\r\n");
      out.write("                                    Aumentar\r\n");
      out.write("                                </strong>\r\n");
      out.write("                                tus ganancias\r\n");
      out.write("                            </p>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"ContenedorFormulario\">\r\n");
      out.write("                    <!-- contenedor formulario -->\r\n");
      out.write("                    <!-- insertar logo -->\r\n");
      out.write("                    <h1 class=\"titulo\">\r\n");
      out.write("                        Confirmar Contraseña\r\n");
      out.write("                    </h1>\r\n");
      out.write("                    <!-- dividir elementos en categorias, se asigna una clase para el elemento ejemplo h1 -->\r\n");
      out.write("                    <form action=\"Registrar\" method=\"post\">\r\n");
      out.write("                        \r\n");
      out.write("                        <label for=\"password\">\r\n");
      out.write("                            Nueva Contraseña:\r\n");
      out.write("                        </label>\r\n");
      out.write("                        <input id=\"password\" name=\"textClaveC\" \r\n");
      out.write("                               placeholder=\"Nueva Contraseña\" required\r\n");
      out.write("                               type=\"password\" onkeyup='check();'\r\n");
      out.write("                               pattern=\"[a-zA-Z0-9_*.%]{12,30}\"\r\n");
      out.write("                               title=\"La contraseña debe tener minimo 12 digitos,\r\n");
      out.write("                               letras, números y carácteres especiales(_*.%)\"><br>\r\n");
      out.write("\r\n");
      out.write("                        <label for=\"password2\">\r\n");
      out.write("                            Confirmar Contraseña:\r\n");
      out.write("                        </label>\r\n");
      out.write("                        <input id=\"password2\" name=\"textclaveC2\" \r\n");
      out.write("                               placeholder=\"Confirmar Contraseña\" required\r\n");
      out.write("                               type=\"password\" onkeyup='check();'\r\n");
      out.write("                               autocomplete=\"none\"\r\n");
      out.write("                               pattern=\"[a-zA-Z0-9_*.%]{12,30}\"\r\n");
      out.write("                               title=\"La contraseña debe tener minimo 12 digitos,\r\n");
      out.write("                               letras, números y carácteres especiales(_*.%)\"><br>\r\n");
      out.write("                        \r\n");
      out.write("                        <div class=\"alert\"> <span id=\"alertamail\"></span></div>\r\n");
      out.write("                        \r\n");
      out.write("\r\n");
      out.write("                        \r\n");
      out.write("                        <div class=\"alert\"> <span id=\"alerta\"></span></div>\r\n");
      out.write("                        <div class=\"MensajeE\">\r\n");
      out.write("\r\n");
      out.write("                            ");

                                if (request.getAttribute("mensajeError") != null) {
                            
      out.write("\r\n");
      out.write("                            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensajeError}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("                            ");
} else {
      out.write("\r\n");
      out.write("                            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensajeExito}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("                            ");
}
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <!--type submit-->\r\n");
      out.write("                        <input name=\"btnenviar\" type=\"submit\" value=\"Restablecer\">\r\n");
      out.write("                        <br>\r\n");
      out.write("                        <br>\r\n");
      out.write("                    </form>\r\n");
      out.write("                    <span class=\"login\">\r\n");
      out.write("                        <a href=\"Login.jsp\">\r\n");
      out.write("                            Ingresar\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </span>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </main>\r\n");
      out.write("        <footer>\r\n");
      out.write("        </footer>\r\n");
      out.write("    </div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
