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
            ArrayList<Boolean> lista = new ArrayList<>();
          lista = (ArrayList<Boolean>)request.getAttribute("styles");
          if(lista.get(0) == true) {
             System.out.println("<html deu certo>");
             System.out.println("funcionou");
          }
          if(lista.get(0) == false){
            System.out.println("nao existe");
          } 
          
          
          if(lista.get(1) == true) {
             System.out.println("<html deu certo>");
             System.out.println("funcionou");
          }
          if(lista.get(1) == false){
            System.out.println("nao existe");
          } 
          
          
          if(lista.get(2) == true) {
             System.out.println("<html deu certo>");
             System.out.println("funcionou");
          }
          if(lista.get(2) == false){
            System.out.println("nao existe");
          } 
             
          
        %>
        
    </body>
</html>
