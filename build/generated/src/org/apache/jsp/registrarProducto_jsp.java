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

public final class registrarProducto_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Registrar Producto</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Registrar Producto</h1>\n");
      out.write("\n");
      out.write("        <form method=\"post\" action=\"Productos\">\n");
      out.write("\n");
      out.write("            <table>\n");
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <th>\n");
      out.write("\n");
      out.write("                        Tipo de Producto  <br>\n");
      out.write("                        <select name=\"textid_tipo_producto\"><br> <br>\n");
      out.write("                            <option>Seleccione...</option> \n");
      out.write("                            ");

                                TipoProductoDAO tipProDao = new TipoProductoDAO(); //ella tiene el metodo
                                for (TipoProductoVO tipProVO : tipProDao.listar()) {
                            
      out.write("\n");
      out.write("\n");
      out.write("                            <option value=\"");
      out.print(tipProVO.getId_tipo_producto());
      out.write('"');
      out.write('>');
      out.print(tipProVO.getNombre_tipo());
      out.write(" </option>\n");
      out.write("\n");
      out.write("                            ");
}
      out.write("\n");
      out.write("                        </select> <br> <br>  \n");
      out.write("\n");
      out.write("\n");
      out.write("                        Categoria  <br>\n");
      out.write("                        <select name=\"textid_categoria\"><br> <br>\n");
      out.write("                            <option>Seleccione...</option> \n");
      out.write("                            ");

                                CategoriaProductoDAO catProDao = new CategoriaProductoDAO(); //ella tiene el metodo
                                for (CategoriaProductoVO catVO : catProDao.listar()) {
                            
      out.write("\n");
      out.write("\n");
      out.write("                            <option value=\"");
      out.print(catVO.getId_categoria());
      out.write('"');
      out.write('>');
      out.print(catVO.getNombre_categoria());
      out.write(" </option>\n");
      out.write("\n");
      out.write("                            ");
}
      out.write("\n");
      out.write("                        </select> <br> <br>\n");
      out.write("\n");
      out.write("                        Nombre Producto  <br>\n");
      out.write("                        <input type=\"text\" name=\"textnombre_producto\"> <br> <br>\n");
      out.write("\n");
      out.write("                        Planta Maquilado  <br>\n");
      out.write("                        <input type=\"text\" name=\"textid_planta\"> <br> <br>\n");
      out.write("\n");
      out.write("                        Peso  <br>\n");
      out.write("                        <input type=\"text\" name=\"textpeso\"> <br> <br>\n");
      out.write("\n");
      out.write("                        Imagen Producto <br>\n");
      out.write("                        <input type=\"text\" name=\"texturl_imagen\"> <br>         <br>     \n");
      out.write("\n");
      out.write("                        Producto Col  <br>\n");
      out.write("                        <input type=\"text\" name=\"textproductocol\"> <br>         <br>  \n");
      out.write("\n");
      out.write("                        id Muestreo  <br>\n");
      out.write("                        <input type=\"text\" name=\"textid_muestreo\"> <br>         <br>  \n");
      out.write("\n");
      out.write("                        Unidades Existentes <br>\n");
      out.write("                        <input type=\"text\" name=\"textunidades_existentes\"> <br>         <br>  \n");
      out.write("\n");
      out.write("                        Precio  <br>\n");
      out.write("                        <input type=\"text\" name=\"textprecio\"> <br>         <br>  \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    </th>\n");
      out.write("\n");
      out.write("                </tr>\n");
      out.write("\n");
      out.write("            </table>  <br>\n");
      out.write("            <button> Registrar\n");
      out.write("\n");
      out.write("            </button>\n");
      out.write("            <input type=\"hidden\" value=\"1\" name=\"opcion\" > ");
      out.write("\n");
      out.write("        </form> <br>\n");
      out.write("\n");
      out.write("\n");
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
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
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
