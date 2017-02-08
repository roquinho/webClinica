<%-- 
    Document   : ViewMedicoBusca
    Created on : 08/02/2017, 00:46:48
    Author     : manoel
--%>

<%@page import="br.clinica.entidades.Medicos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
         Medicos medico = (Medicos)request.getAttribute("buscaMedico");
         out.println(medico);
        %>
    </body>
</html>
