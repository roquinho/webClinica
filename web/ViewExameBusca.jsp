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
        %>
        
        <table style="width:100%">
  <tr>
    <th>nome do paciente</th>
    <th>cpf do paciente</th> 
    <th>hora do exame</th>
    <th>dia do exame</th>
    <th>tipo do exame</th> 
    

  </tr>
  <tr>
    <td><%=exame.getPaciente().getNome()%></td>
    <td><%=exame.getPaciente().getCpf()%></td>
    <td><%=exame.getHoraExame()%></td>
    <td><%=exame.getDataExame()%></td>
    <td><%=exame.getTipoExame()%></td>
    
  </tr>
  <tr>
 
  </tr>
 
    </body>
</html>
