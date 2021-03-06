<%-- 
    Document   : reporteParametrizado
    Created on : 28/05/2021, 08:19:28 PM
    Author     : aamaya
--%>

<%@page import="net.sf.jasperreports.engine.JasperRunManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.lina.util.Conexion"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
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
%>
    </body>
</html>
