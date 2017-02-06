<%-- 
    Document   : LoginView
    Created on : 06/02/2017, 11:16:31
    Author     : manoel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
          boolean login = (Boolean)request.getAttribute("styles");
          if(login == true) {
             System.out.println("<html deu certo>");
             System.out.println("funcionou");
          }
          if(login == false){
            System.out.println("nao existe");
          }   
        %>
        
    </body>
</html>
