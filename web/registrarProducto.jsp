<%-- 
    Document   : registrarVehiculo
    Created on : 26/04/2021, 12:42:02 PM
    Author     : aamaya

-Cuando una llave primaria pasa como foranea a otra tabla
necesita relacionar algun dato

--%>

<%@page import="com.lina.vo.PlantaLinadoVO"%>
<%@page import="com.lina.modelo.PlantaLinadoDAO"%>
<%@page import="com.lina.vo.TipoProductoVO"%>
<%@page import="com.lina.modelo.TipoProductoDAO"%>
<%@page import="com.lina.vo.CategoriaProductoVO"%>
<%@page import="com.lina.modelo.CategoriaProductoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Producto</title>
    </head>
    <body>
        <h1>Registrar Producto</h1>

        <form method="post" action="Productos">

            <table>

                <tr>
                    <th>

                        Tipo de Producto  <br>
                        <select name="textid_tipo_producto"><br> <br>
                            <option>Seleccione...</option> 
                            <%
                                TipoProductoDAO tipProDao = new TipoProductoDAO(); //ella tiene el metodo
                                for (TipoProductoVO tipProVO : tipProDao.listar()) {
                            %>

                            <option value="<%=tipProVO.getId_tipo_producto()%>"><%=tipProVO.getNombre_tipo()%> </option>

                            <%}%>
                        </select> <br> <br>  


                        Categoria  <br>
                        <select name="textid_categoria"><br> <br>
                            <option>Seleccione...</option> 
                            <%
                                CategoriaProductoDAO catProDao = new CategoriaProductoDAO(); //ella tiene el metodo
                                for (CategoriaProductoVO catVO : catProDao.listar()) {
                            %>

                            <option value="<%=catVO.getId_categoria()%>"><%=catVO.getNombre_categoria()%> </option>

                            <%}%>
                        </select> <br> <br>

                        Nombre Producto  <br>
                        <input type="text" name="textnombre_producto"> <br> <br>

                        Planta Maquilado  <br>
                        <input type="text" name="textid_planta"> <br> <br>

                        Peso  <br>
                        <input type="text" name="textpeso"> <br> <br>

                        Imagen Producto <br>
                        <input type="text" name="texturl_imagen"> <br>         <br>     

                        Producto Col  <br>
                        <input type="text" name="textproductocol"> <br>         <br>  

                        id Muestreo  <br>
                        <input type="text" name="textid_muestreo"> <br>         <br>  

                        Unidades Existentes <br>
                        <input type="text" name="textunidades_existentes"> <br>         <br>  

                        Precio  <br>
                        <input type="text" name="textprecio"> <br>         <br>  



                    </th>

                </tr>

            </table>  <br>
            <button> Registrar

            </button>
            <input type="hidden" value="1" name="opcion" > <%-- 39 value es el numero de caso, contenido oculto, opcion valor a recoger --%>
        </form> <br>


        <div style="color:red"> <%-- codigo java --%>
            <%                    if (request.getAttribute("mensajeError") != null) {
            %>
            <%-- imprimir mensaje en jsp ${} --%>

            ${mensajeError}
            <%
            } else { %>
            ${mensajeExito}
            <%}%>
        </div>



    </body>
</html>
