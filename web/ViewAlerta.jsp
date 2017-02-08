<%-- 
    Document   : ViewPacienteCadastro
    Created on : 08/02/2017, 01:19:19
    Author     : manoel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        String alerta = (String)request.getAttribute("alerta");
           out.println(alerta);
        %> 
    </body>
</html>
