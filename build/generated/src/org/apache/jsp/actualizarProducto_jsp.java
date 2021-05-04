package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.lina.vo.productoVO;

public final class actualizarProducto_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Actualizar Productos</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <center>\n");
      out.write("\n");
      out.write("        <h1>Actualizar Productos</h1>\n");
      out.write("        ");

            productoVO proVO = (productoVO) request.getAttribute("Datos Consultados"); //crear objeto asignandole un valor de una vez
            //
            if (proVO != null) {

        
      out.write("\n");
      out.write("\n");
      out.write("        <form method=\"post\" action=\"Productos\">\n");
      out.write("\n");
      out.write("            <table>\n");
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <th>\n");
      out.write("                        ID Producto  <br>\n");
      out.write("                        <input type=\"text\" name=\"textvehplaca\" value=\"");
      out.print(proVO.getId_producto());
      out.write("\" ><br> <br>\n");
      out.write("\n");
      out.write("                        Tipo Producto  <br>\n");
      out.write("                        <input type=\"text\" name=\"textDatos\" value=\"");
      out.print(proVO.getId_tipo_producto());
      out.write("\" ><br> <br>\n");
      out.write("\n");
      out.write("                        Categoria  <br>\n");
      out.write("                        <input type=\"text\" name=\"textCategoria\" value=\"");
      out.print(proVO.getId_categoria());
      out.write("\" ><br> <br>\n");
      out.write("\n");
      out.write("                        Nombre  <br>\n");
      out.write("                        <input type=\"text\" name=\"textModelo\" value=\"");
      out.print(proVO.getNombre_producto());
      out.write("\" ><br> <br>\n");
      out.write("\n");
      out.write("                        Planta Maquilado  <br>\n");
      out.write("                        <input type=\"text\" name=\"textMarca\" value=\"");
      out.print(proVO.getId_planta());
      out.write("\" > <br> <br>\n");
      out.write("\n");
      out.write("                        Peso  <br>\n");
      out.write("                        <input type=\"text\" name=\"textEstado\" value=\"");
      out.print(proVO.getPeso());
      out.write("\" ><br> <br>\n");
      out.write("\n");
      out.write("                        Imagen Producto  <br>\n");
      out.write("                        <input type=\"text\" name=\"textPrecio\" value=\"");
      out.print(proVO.getUrl_imagen());
      out.write("\" ><br><br>    \n");
      out.write("                        \n");
      out.write("                                                Producto Col  <br>\n");
      out.write("                        <input type=\"text\" name=\"textPrecio\" value=\"");
      out.print(proVO.getProductocol() );
      out.write("\" ><br><br>   \n");
      out.write("                        \n");
      out.write("                                                Muestreo  <br>\n");
      out.write("                        <input type=\"text\" name=\"textPrecio\" value=\"");
      out.print(proVO.getId_muestreo());
      out.write("\" ><br><br>   \n");
      out.write("                        \n");
      out.write("                                                Unidades Existentes  <br>\n");
      out.write("                        <input type=\"text\" name=\"textPrecio\" value=\"");
      out.print(proVO.getUnidades_existentes());
      out.write("\" ><br><br>   \n");
      out.write("                        \n");
      out.write("                                                Precio  <br>\n");
      out.write("                        <input type=\"text\" name=\"textPrecio\" value=\"");
      out.print(proVO.getPrecio());
      out.write("\" ><br><br>   \n");
      out.write("\n");
      out.write("                    </th>\n");
      out.write("\n");
      out.write("                </tr>\n");
      out.write("\n");
      out.write("            </table>  <br>\n");
      out.write("            <button> Actualizar\n");
      out.write("\n");
      out.write("            </button>\n");
      out.write("            <input type=\"hidden\" value=\"2\" name=\"opcion\" > ");
      out.write("\n");
      out.write("        </form> <br>\n");
      out.write("\n");
      out.write("\n");
      out.write("        ");
}
        
      out.write("\n");
      out.write("        <a href=\"consultarProducto.jsp\" >Volver</a>\n");
      out.write("        <div style=\"color:red\"> ");
      out.write("\n");
      out.write("            ");

                if (request.getAttribute("mensajeError") != null) {
            
      out.write("\n");
      out.write("            ");
      out.write("\n");
      out.write("\n");
      out.write("            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensajeError}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("            ");

            } else { 
      out.write("\n");
      out.write("            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensajeExito}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("            ");
}
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </centeR>\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
