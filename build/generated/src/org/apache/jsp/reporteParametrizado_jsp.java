package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import net.sf.jasperreports.engine.JasperRunManager;
import java.sql.Connection;
import com.lina.util.Conexion;
import java.util.Map;
import java.util.HashMap;
import java.io.File;

public final class reporteParametrizado_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
 
//llamar un objeto file para indicar que almanece elementos, 
//realparth contenedores donde esta el reporte

File reporteProductos = new File(application.getRealPath("reporteParametrizado.jasper"));

//hacer un mapeo
// recorrer y convertir objeto con map

Map<String,Object> parametros = new HashMap<String, Object>();

String tipoProducto = request.getParameter("tipo");//tipo variable de report, recibe
parametros.put("tipo", new String("tipo") ); //coge parametro y lo asigna, crear variable y where en jasper primero

//sacar reporte de db

Conexion conexionBD = new Conexion(); //instanciar conexión
 Connection conexion = conexionBD.obtenerConexion(); // obtener metodo conexión
 
//convertir reporte en byte
//jasper librerias no nativas de java, se deben importar bombillo add jasper

byte[] reporteBytes = JasperRunManager.runReportToPdf(reporteProductos.getPath(),parametros,conexion);
//convierta en arreglo de bytes, en pdf con administrador, nombre reporte, parametros el mapeo del reporte, conexion para obtener datos
response.setContentType("application/pdf");
//asignar tipo de elemento, aplicacion pdf
response.setContentLength(reporteBytes.length); //tamaño el reporte, tamaño de arreglo que se recorrio
response.setHeader("Content-Disposition", "filename=\"nombre_de_tu_fichero.pdf\";");

//generar salida, exportar archivo
ServletOutputStream salida = response.getOutputStream(); //response peticiones http, outputStream genera almacenamiento temporal
//mostrar en pdf

salida.write(reporteBytes,0,reporteBytes.length); //0 apagado es decir genera reporte cuando lo silicite el usuario

salida.flush(); //genera escritura y exportación del archivo
salida.close();

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
