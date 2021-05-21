package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.lina.vo.PlantaLinadoVO;
import com.lina.modelo.PlantaLinadoDAO;
import com.lina.vo.TipoProductoVO;
import com.lina.modelo.TipoProductoDAO;
import com.lina.vo.CategoriaProductoVO;
import com.lina.modelo.CategoriaProductoDAO;

public final class registrarProductoold_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Registrar Producto</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <h1>Registrar Producto</h1>\r\n");
      out.write("\r\n");
      out.write("        <form method=\"post\" action=\"Productos\">\r\n");
      out.write("\r\n");
      out.write("            <table>\r\n");
      out.write("\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <th>\r\n");
      out.write("\r\n");
      out.write("                        Tipo de Producto  <br>\r\n");
      out.write("                        <select name=\"textid_tipo_producto\"><br> <br>\r\n");
      out.write("                            <option>Seleccione...</option> \r\n");
      out.write("                            ");

                                TipoProductoDAO tipProDao = new TipoProductoDAO(); //ella tiene el metodo
                                for (TipoProductoVO tipProVO : tipProDao.listar()) {
                            
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            <option value=\"");
      out.print(tipProVO.getId_tipo_producto());
      out.write('"');
      out.write('>');
      out.print(tipProVO.getNombre_tipo());
      out.write(" </option>\r\n");
      out.write("\r\n");
      out.write("                            ");
}
      out.write("\r\n");
      out.write("                        </select> <br> <br>  \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        Categoria  <br>\r\n");
      out.write("                        <select name=\"textid_categoria\"><br> <br>\r\n");
      out.write("                            <option>Seleccione...</option> \r\n");
      out.write("                            ");

                                CategoriaProductoDAO catProDao = new CategoriaProductoDAO(); //ella tiene el metodo
                                for (CategoriaProductoVO catVO : catProDao.listar()) {
                            
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            <option value=\"");
      out.print(catVO.getId_categoria());
      out.write('"');
      out.write('>');
      out.print(catVO.getNombre_categoria());
      out.write(" </option>\r\n");
      out.write("\r\n");
      out.write("                            ");
}
      out.write("\r\n");
      out.write("                        </select> <br> <br>\r\n");
      out.write("\r\n");
      out.write("                        Nombre Producto  <br>\r\n");
      out.write("                        <input type=\"text\" name=\"textnombre_producto\"> <br> <br>\r\n");
      out.write("\r\n");
      out.write("                        Planta Maquilado  <br>\r\n");
      out.write("                        <input type=\"text\" name=\"textid_planta\"> <br> <br>\r\n");
      out.write("\r\n");
      out.write("                        Peso  <br>\r\n");
      out.write("                        <input type=\"text\" name=\"textpeso\"> <br> <br>\r\n");
      out.write("\r\n");
      out.write("                        Imagen Producto <br>\r\n");
      out.write("                        <input type=\"text\" name=\"texturl_imagen\"> <br>         <br>     \r\n");
      out.write("\r\n");
      out.write("                        Producto Col  <br>\r\n");
      out.write("                        <input type=\"text\" name=\"textproductocol\"> <br>         <br>  \r\n");
      out.write("\r\n");
      out.write("                        id Muestreo  <br>\r\n");
      out.write("                        <input type=\"text\" name=\"textid_muestreo\"> <br>         <br>  \r\n");
      out.write("\r\n");
      out.write("                        Unidades Existentes <br>\r\n");
      out.write("                        <input type=\"text\" name=\"textunidades_existentes\"> <br>         <br>  \r\n");
      out.write("\r\n");
      out.write("                        Precio  <br>\r\n");
      out.write("                        <input type=\"text\" name=\"textprecio\"> <br>         <br>  \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    </th>\r\n");
      out.write("\r\n");
      out.write("                </tr>\r\n");
      out.write("\r\n");
      out.write("            </table>  <br>\r\n");
      out.write("            <button> Registrar\r\n");
      out.write("\r\n");
      out.write("            </button>\r\n");
      out.write("            <input type=\"hidden\" value=\"1\" name=\"opcion\" > ");
      out.write("\r\n");
      out.write("        </form> <br>\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
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
