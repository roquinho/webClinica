<%-- 
    Document   : ViewConsultaBusca
    Created on : 08/02/2017, 00:47:29
    Author     : manoel
--%>

<%@page import="br.clinica.entidades.Consultas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        Consultas consulta = (Consultas)request.getAttribute("buscaConsulta");
        out.println(consulta);
        %>
    </body>
</html>
