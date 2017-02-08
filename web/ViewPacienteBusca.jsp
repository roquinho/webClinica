<%-- 
    Document   : pacientesBuscaJsp
    Created on : 08/02/2017, 00:30:54
    Author     : manoel
--%>

<%@page import="br.clinica.entidades.Pacientes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      
        <%
        Pacientes paciente = (Pacientes)request.getAttribute("buscaPaciente");
        %>
  <table style="width:100%">
  <tr>
    <th>nome</th>
    <th>endereco</th> 
    <th>telefone</th>
    <th>sexo</th>
    <th>data de nascimento</th> 
    <th>cpf</th>

  </tr>
  <tr>
    <td><%=paciente.getNome()%></td>
    <td><%=paciente.getEndereco()%></td>
    <td><%=paciente.getTelefone()%></td>
    <td><%=paciente.getSexo()%></td>
    <td><%=paciente.getDataNascimento()%></td>
    <td><%=paciente.getCpf()%></td>
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

<h2>paciente</h2>  
        
          
    </body>
        
       
</html>
