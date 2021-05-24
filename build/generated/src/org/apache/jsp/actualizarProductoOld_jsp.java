package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.lina.vo.productoVO;

public final class actualizarProductoOld_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Actualizar Productos</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("    <center>\r\n");
      out.write("\r\n");
      out.write("        <h1>Actualizar Productos</h1>\r\n");
      out.write("        ");

            productoVO proVO = (productoVO) request.getAttribute("Datos Consultados"); //crear objeto asignandole un valor de una vez
            //
            if (proVO != null) {

        
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <form method=\"post\" action=\"Productos\">\r\n");
      out.write("\r\n");
      out.write("            <table>\r\n");
      out.write("\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <th>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        ID Producto  <br>\r\n");
      out.write("\r\n");
      out.write("                        <input type=\"text\" name=\"textid_producto\" value=\"");
      out.print(proVO.getId_tipo_producto());
      out.write("\" ><br> <br>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        Tipo Producto  <br>\r\n");
      out.write("\r\n");
      out.write("                        <input type=\"text\" name=\"textid_tipo_producto\" value=\"");
      out.print(proVO.getId_tipo_producto());
      out.write("\" ><br> <br>\r\n");
      out.write("\r\n");
      out.write("                        Categoria  <br>\r\n");
      out.write("                        <input type=\"text\" name=\"textid_categoria\" value=\"");
      out.print(proVO.getId_categoria());
      out.write("\" ><br> <br>\r\n");
      out.write("\r\n");
      out.write("                        Nombre Producto  <br>\r\n");
      out.write("                        <input type=\"text\" name=\"textnombre_producto\" value=\"");
      out.print(proVO.getNombre_producto());
      out.write("\" ><br> <br>\r\n");
      out.write("\r\n");
      out.write("                        Planta Maquilado  <br>\r\n");
      out.write("                        <input type=\"text\" name=\"textid_planta\" value=\"");
      out.print(proVO.getId_planta());
      out.write("\" > <br> <br>\r\n");
      out.write("\r\n");
      out.write("                        Peso  <br>\r\n");
      out.write("                        <input type=\"text\" name=\"textpeso\" value=\"");
      out.print(proVO.getPeso());
      out.write("\" ><br> <br>\r\n");
      out.write("\r\n");
      out.write("                        Imagen Producto  <br>\r\n");
      out.write("                        <input type=\"text\" name=\"texturl_imagen\" value=\"");
      out.print(proVO.getUrl_imagen());
      out.write("\" ><br><br>    \r\n");
      out.write("\r\n");
      out.write("                        Producto Col  <br>\r\n");
      out.write("                        <input type=\"text\" name=\"textproductocol\" value=\"");
      out.print(proVO.getProductocol());
      out.write("\" ><br><br>   \r\n");
      out.write("\r\n");
      out.write("                        Muestreo  <br>\r\n");
      out.write("                        <input type=\"text\" name=\"textid_muestreo\" value=\"");
      out.print(proVO.getId_muestreo());
      out.write("\" ><br><br>   \r\n");
      out.write("\r\n");
      out.write("                        Unidades Existentes  <br>\r\n");
      out.write("                        <input type=\"text\" name=\"textunidades_existentes\" value=\"");
      out.print(proVO.getUnidades_existentes());
      out.write("\" ><br><br>   \r\n");
      out.write("\r\n");
      out.write("                        Precio  <br>\r\n");
      out.write("                        <input type=\"text\" name=\"textprecio\" value=\"");
      out.print(proVO.getPrecio());
      out.write("\" ><br><br>   \r\n");
      out.write("\r\n");
      out.write("                    </th>\r\n");
      out.write("\r\n");
      out.write("                </tr>\r\n");
      out.write("\r\n");
      out.write("            </table>  <br>\r\n");
      out.write("            <button> Actualizar\r\n");
      out.write("\r\n");
      out.write("            </button>\r\n");
      out.write("            <input type=\"hidden\" value=\"2\" name=\"opcion\" > ");
      out.write("\r\n");
      out.write("        </form> <br>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        ");
}
        
      out.write("\r\n");
      out.write("        <a href=\"consultarProducto.jsp\" >Volver</a>\r\n");
      out.write("        <div style=\"color:red\"> ");
      out.write("\r\n");
      out.write("            ");

                if (request.getAttribute("mensajeError") != null) {
            
      out.write("\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensajeError}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("            ");

            } else { 
      out.write("\r\n");
      out.write("            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensajeExito}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("            ");
}
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("    </centeR>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
