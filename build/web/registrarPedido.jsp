<%-- 
    Document   : registrarPedido
    Created on : 5/05/2021, 06:20:05 PM
    Author     : Nidia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Pedido</title>
    </head>
    <body>
    <center>
        <h1>Registrar Pedidos!</h1>

        <form method="post" action="Pedido">

            <table>
                <tr>
               
                id usuario: <br>
                <input type="text" name="textid_usuario"><br>
              
                <label for="textfecha_pedido">Fecha pedido:</label><br>
               <input type="date" id="textfecha_pedido" name="textfecha_pedido"><br>
                
                Fecha entrega <br>
                <input type="date" name="textfecha_entrega"><br>
                Forma de envio: <br>
                <input type="text" name="textforma_envio">
                
                </tr>
            </table><br>
            <button> Registrar Pedido</button>
            <input type="hidden" value="1" name="opcion">

            <div style="color: red;">

                <%
                    if (request.getAttribute("MensajeError") != null) {
                %>
                ${MensajeError}
                <%} %>
               

            </div>
                
             <div style="color: green;">

                <%
                    if (request.getAttribute("mensajeExito") != null) {
                %>
                ${mensajeExito}
                <%}  %>

            </div>

        </form>
    </center>

</body>
</html>