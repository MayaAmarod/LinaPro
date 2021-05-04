<%-- 
    Document   : LinaHome
    Created on : 1/04/2021, 04:44:18 PM
    Author     : wilso
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lina Home</h1>
        
        Bienvenido:
        <%
            String user = (String) request.getSession().getAttribute("Usuario");
                        if (user != null) {
                            out.println("<font size=4px>" + user + "</font>");
                        }
                    %>
    </body>
</html>
