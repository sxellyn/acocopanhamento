<%-- 
    Document   : TestForm
    Created on : Dec 11, 2024, 11:34:45 AM
    Author     : ALUNO
--%>

<%@page import="br.edu.ifpe.recife.model.negocio.CondicaoClinica"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="ifpe" uri="http://www.ifpe.edu.br/recife/ifpetags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <ifpe:criaForm classe="<%= br.edu.ifpe.recife.model.negocio.CondicaoClinica.class%>"
                       submitURL="Condicao"/>
    </body>
</html>
