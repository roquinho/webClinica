<%-- 
    Document   : ViewUsuarioBusca
    Created on : 08/02/2017, 00:47:11
    Author     : manoel
--%>

<%@page import="br.clinica.entidades.Usuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        Usuarios usuario = (Usuarios)request.getAttribute("buscaUsuario");
        out.println(usuario);
        %>
    </body>
</html>
