<%-- 
    Document   : actualizarPedido
    Created on : 6/05/2021, 05:59:22 PM
    Author     : Nidia
--%>

<%@page import="com.lina.vo.PedidoVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Actualizar Pedido</title>
    </head>
    <body>
    <center>

        <h1>Actualizar Pedido</h1>
        <%
           PedidoVO pedVO = (PedidoVO) request.getAttribute("Datos Consultados"); 
            //
            if (pedVO != null) {

        %>

        <form method="post" action="Pedido">

            <table>

                <tr>
                    <th>


                        ID Pedido  <br>

                        <input type="text" name="textid_pedido" value="<%=pedVO.getId_Pedido()%>" ><br> <br>


                        ID Usuario  <br>

                        <input type="text" name="textid_usuario" value="<%=pedVO.getId_Usuario()%>" ><br> <br>

                       Fecha de Pedido  <br>
                        <input type="text" name="textfecha_pedido" value="<%=pedVO.getFecha_Pedido()%>" ><br> <br>

                      Fecha de Entrega <br>
                        <input type="text" name="textfecha_entrega" value="<%=pedVO.getFecha_Entrega()%>" ><br> <br>

                        Forma de Envio <br>
                        <input type="text" name="textforma_envio" value="<%=pedVO.getForma_Envio()%>" > <br> <br>

                        

                    </th>

                </tr>

            </table>  <br>
            <button> Actualizar

            </button>
            <input type="hidden" value="2" name="opcion" > <%-- 39 value es el numero de caso, contenido oculto, opcion valor a recoger --%>
        </form> <br>


        <%}
        %>
        <a href="consultarPedido.jsp" >Volver</a>
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
