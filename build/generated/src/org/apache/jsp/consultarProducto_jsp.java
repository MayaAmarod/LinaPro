package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.lina.vo.productoVO;
import com.lina.modelo.ProductoDAO;
import java.util.ArrayList;

public final class consultarProducto_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Productos</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <center>\n");
      out.write("        <h1>Productos</h1>\n");
      out.write("\n");
      out.write("        <form action=\"Productos\" method=\"post\">\n");
      out.write("\n");
      out.write("            <table>\n");
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <th>\n");
      out.write("                        Ingrese Nombre Producto: <br>\n");
      out.write("                        <input type=\"text\" name=\"textnombre_producto\" <br> <br>\n");
      out.write("                    </th>\n");
      out.write("                </tr>\n");
      out.write("            </table><br><br>\n");
      out.write("            <button>Consultar</button>\n");
      out.write("            <input type=\"hidden\" value=\"3\" name=\"opcion\" > \n");
      out.write("\n");
      out.write("        </form><br><br>\n");
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
      out.write("        </div><br><br>\n");
      out.write("\n");
      out.write("        <form>\n");
      out.write("\n");
      out.write("            <table border=\"1\">\n");
      out.write("\n");
      out.write("                <tr>\n");
      out.write("\n");
      out.write("                    <th>ID Producto</th>\n");
      out.write("                    <th>Tipo de Producto</th>\n");
      out.write("                    <th>Categoria</th>\n");
      out.write("                    <th>Nombre Producto</th>\n");
      out.write("                    <th>Planta</th>\n");
      out.write("                    <th>Peso</th>\n");
      out.write("                    <th>Imagen</th>\n");
      out.write("                    <th>Producto Col</th>\n");
      out.write("                    <th>Muestreo</th>\n");
      out.write("                    <th>Unidades Existentes</th>\n");
      out.write("                    <th>Precio</th>\n");
      out.write("\n");
      out.write("\n");
      out.write("                </tr>\n");
      out.write("\n");
      out.write("                ");


                    productoVO proVO = new productoVO(); //se deja vacio porque no va a enviar sino recibir, no pasa x controlador
                   ProductoDAO proDAO = new ProductoDAO(); //no va a hacer iPeraciones con datos del VO
                    //vamos a vehiculo DAO seleccionar variables y generan constructor vacio para llamarlo
                    ArrayList<productoVO> listaProductos = proDAO.listar(); //se declara un array para recibir los datos <se coloca el objeto, STRING, BOOLEAN>

                    for (int i = 0; i < listaProductos.size(); i++) {
                        proVO = listaProductos.get(i);

                
      out.write("\n");
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print(proVO.getId_producto());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(proVO.getId_tipo_producto());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(proVO.getId_categoria());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(proVO.getNombre_producto());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(proVO.getId_planta());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(proVO.getPeso());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(proVO.getUrl_imagen());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(proVO.getProductocol());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(proVO.getId_muestreo());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(proVO.getUnidades_existentes());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print(proVO.getPrecio());
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("    </center>\n");
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
