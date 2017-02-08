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
       
        %>
        
        <table style="width:100%">
  <tr>
    <th>nome</th>
    <th>senha</th> 
    <th>tipo Usuario</th>
    <th>cpf</th>
    
  </tr>
  <tr>
    <td><%=usuario.getNome()%></td>
    <td><%=usuario.getSenha()%></td>
    <td><%=usuario.getTipoUsuario()%></td>
    <td><%=usuario.getCpf()%></td>
    
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

<h2>usuarios</h2>
    </body>
</html>
