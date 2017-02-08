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
         out.println(paciente);
            %>
          
            
        
    </body>
        
       
</html>
