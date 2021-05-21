<%-- 
    Document   : consultarPedido
    Created on : 6/05/2021, 08:01:50 PM
    Author     : Nidia
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.lina.modelo.PedidoDAO"%>
<%@page import="com.lina.vo.PedidoVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pedidos</title>
    </head>
    <body>
    <center>
        <h1>Pedidos</h1>

        <form action="Pedido" method="post">

            <table>

                <tr>
                    <th>
                        Ingrese Fecha de Pedido: <br>
                        <input type="text" name="textfecha_pedido" <br> <br>
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

                    <th>ID Pedido</th>
                    <th>ID Usuario</th>
                    <th>Fecha de Pedido</th>
                    <th>Fecha de Entrega</th>
                    <th>Forma de Envio</th>
                  
                </tr>

                <%

                    PedidoVO pedVO = new PedidoVO();
                   PedidoDAO pedDAO = new PedidoDAO(); 
                  
                    ArrayList<PedidoVO> listaPedidos = pedDAO.listar(); 

                    for (int i = 0; i < listaPedidos .size(); i++) {
                        pedVO = listaPedidos .get(i);

                %>

                <tr>
                    <td><%=pedVO.getId_Pedido()%></td>
                    <td><%=pedVO.getId_Usuario()%></td>
                    <td><%=pedVO.getFecha_Pedido()%></td>
                    <td><%=pedVO.getFecha_Entrega()%></td>
                    <td><%=pedVO.getForma_Envio()%></td>
                   
                </tr>
                <%}%>
            </table>
        </form>
    </center>
</body>
</html>
