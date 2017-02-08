<%-- 
    Document   : LoginView
    Created on : 06/02/2017, 11:16:31
    Author     : manoel
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>      
                    
  <%
      ArrayList<Boolean> login = (ArrayList<Boolean>)request.getAttribute("login");
      
       
         if(login.get(0) == true) {   
          String redirectURL = "http://localhost:8080/webClinica/Buscar_paciente.html";
          response.sendRedirect(redirectURL);
         }
        else if(login.get(1)==true) {
          String redirectURL = "http://localhost:8080/webClinica/indexpacientes.html";
          response.sendRedirect(redirectURL);
         }
        else if(login.get(2)==true) {
          String redirectURL = "http://localhost:8080/webClinica/indexpacientes.html";
          response.sendRedirect(redirectURL);
         }
      
        
  %>

        
    </body>
</html>
