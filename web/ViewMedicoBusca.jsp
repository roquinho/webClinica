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
        %>
        
        <table style="width:100%">
  <tr>
    <th>nome</th>
    <th>endereco</th> 
    <th>telefone</th>
    <th>especialidade</th>
    <th>crm</th> 
    <th>cpf</th>

  </tr>
  <tr>
    <td><%=medico.getNome()%></td>
    <td><%=medico.getEndereco()%></td>
    <td><%=medico.getTelefone()%></td>
    <td><%=medico.getEspecialidade()%></td>
    <td><%=medico.getCrm()%></td>
    <td><%=medico.getCpf()%></td>
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

<h2>medico</h2>
    </body>
</html>
