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
          
        %>
        
             
        <table style="width:100%">
  <tr>
    <th>nome do paciente</th>
    <th>cpf do paciente</th> 
    <th>hora da consulta</th>
    <th>dia da consulta</th>
    <th>cpf do medico</th> 
    

  </tr>
  <tr>
    <td><%=consulta.getPaciente().getNome()%></td>
    <td><%=consulta.getPaciente().getCpf()%></td>
    <td><%=consulta.getHoraConsulta()%></td>
    <td><%=consulta.getDiaConsulta()%></td>
    <td><%=consulta.getMedico().getNome()%></td>
    
  </tr>
  <tr>
 
  </tr>
 <style>
table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
    background-color: #4CAF50;
    color: white;
}
</style>
</head>
<body>

<h2>Consulta</h2>

    </body>
</html>
