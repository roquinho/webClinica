<%-- 
    Document   : ViewExameBusca
    Created on : 08/02/2017, 00:47:46
    Author     : manoel
--%>

<%@page import="br.clinica.entidades.Exames"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        Exames exame = (Exames)request.getAttribute("buscaExame");
        out.println(exame);
        %>
    </body>
</html>
