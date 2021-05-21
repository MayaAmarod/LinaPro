<%-- 
    Document   : consultarVehiculo
    Created on : 26/04/2021, 02:57:59 PM
    Author     : aamaya
--%>

<%@page import="com.lina.vo.productoVO"%>
<%@page import="com.lina.modelo.ProductoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos</title>
    </head>
    <body>
    <center>
        <h1>Productos</h1>

        <form action="Productos" method="post">

            <table>

                <tr>
                    <th>
                        Ingrese Nombre Producto: <br>
                        <input type="text" name="textid_producto" <br> <br>
                    </th>
                </tr>
            </table><br><br>
            <button>Consultar</button>
            <input type="hidden" value="3" name="opcion" > 

        </form><br><br>

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
        </div><br><br>

        <form>

            <table border="1">

                <tr>

                    <th>ID Producto</th>
                    <th>Tipo de Producto</th>
                    <th>Categoria</th>
                    <th>Nombre Producto</th>
                    <th>Planta</th>
                    <th>Peso</th>
                    <th>Imagen</th>
                    <th>Producto Col</th>
                    <th>Muestreo</th>
                    <th>Unidades Existentes</th>
                    <th>Precio</th>


                </tr>

                <%

                    productoVO proVO = new productoVO(); //se deja vacio porque no va a enviar sino recibir, no pasa x controlador
                    ProductoDAO proDAO = new ProductoDAO(); //no va a hacer iPeraciones con datos del VO
                    //vamos a vehiculo DAO seleccionar variables y generan constructor vacio para llamarlo
                    ArrayList<productoVO> listaProductos = proDAO.listar(); //se declara un array para recibir los datos <se coloca el objeto, STRING, BOOLEAN>

                    for (int i = 0; i < listaProductos.size(); i++) {
                        proVO = listaProductos.get(i);

                %>

                <tr>
                    <td><%=proVO.getId_producto()%></td>
                    <td><%=proVO.getId_tipo_producto()%></td>
                    <td><%=proVO.getId_categoria()%></td>
                    <td><%=proVO.getNombre_producto()%></td>
                    <td><%=proVO.getId_planta()%></td>
                    <td><%=proVO.getPeso()%></td>
                    <td><%=proVO.getUrl_imagen()%></td>
                    <td><%=proVO.getProductocol()%></td>
                    <td><%=proVO.getId_muestreo()%></td>
                    <td><%=proVO.getUnidades_existentes()%></td>
                    <td><%=proVO.getPrecio()%></td>
                </tr>
                <%}%>
            </table>
        </form>
    </center>
</body>
</html>
