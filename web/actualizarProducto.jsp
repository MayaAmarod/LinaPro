<%-- 
    Document   : actualizarVehiculo
    Created on : 26/04/2021, 03:13:59 PM
    Author     : aamaya
--%>

<%@page import="com.lina.vo.productoVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Productos</title>
    </head>
    <body>
    <center>

        <h1>Actualizar Productos</h1>
        <%
            productoVO proVO = (productoVO) request.getAttribute("Datos Consultados"); //crear objeto asignandole un valor de una vez
            //
            if (proVO != null) {

        %>

        <form method="post" action="Productos">

            <table>

                <tr>
                    <th>


                        ID Producto  <br>

                        <input type="text" name="textid_producto" value="<%=proVO.getId_tipo_producto()%>" ><br> <br>


                        Tipo Producto  <br>

                        <input type="text" name="textid_tipo_producto" value="<%=proVO.getId_tipo_producto()%>" ><br> <br>

                        Categoria  <br>
                        <input type="text" name="textid_categoria" value="<%=proVO.getId_categoria()%>" ><br> <br>

                        Nombre Producto  <br>
                        <input type="text" name="textnombre_producto" value="<%=proVO.getNombre_producto()%>" ><br> <br>

                        Planta Maquilado  <br>
                        <input type="text" name="textid_planta" value="<%=proVO.getId_planta()%>" > <br> <br>

                        Peso  <br>
                        <input type="text" name="textpeso" value="<%=proVO.getPeso()%>" ><br> <br>

                        Imagen Producto  <br>
                        <input type="text" name="texturl_imagen" value="<%=proVO.getUrl_imagen()%>" ><br><br>    

                        Producto Col  <br>
                        <input type="text" name="textproductocol" value="<%=proVO.getProductocol()%>" ><br><br>   

                        Muestreo  <br>
                        <input type="text" name="textid_muestreo" value="<%=proVO.getId_muestreo()%>" ><br><br>   

                        Unidades Existentes  <br>
                        <input type="text" name="textunidades_existentes" value="<%=proVO.getUnidades_existentes()%>" ><br><br>   

                        Precio  <br>
                        <input type="text" name="textprecio" value="<%=proVO.getPrecio()%>" ><br><br>   

                    </th>

                </tr>

            </table>  <br>
            <button> Actualizar

            </button>
            <input type="hidden" value="2" name="opcion" > <%-- 39 value es el numero de caso, contenido oculto, opcion valor a recoger --%>
        </form> <br>


        <%}
        %>
        <a href="consultarProducto.jsp" >Volver</a>
        <div style="color:red"> <%-- codigo java --%>
            <%
                if (request.getAttribute("mensajeError") != null) {
            %>
            <%-- imprimir mensaje en jsp ${} --%>

            ${mensajeError}
            <%
            } else { %>
            ${mensajeExito}
            <%}%>
        </div>

    </centeR>
</body>
</html>
