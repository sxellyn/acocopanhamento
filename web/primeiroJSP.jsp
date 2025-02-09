<%-- 
    Document   : primeiroJSP
    Created on : Nov 27, 2024, 10:41:13 AM
    Author     : ALUNO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%! int i = 0;
        %>
        <%! int b = 0;%>

        <%
            for (int j = 0; j < 10; j++) {
                i = i + 1;
                if (i%2 == 0) {
                    %>
                    <h4><%= i%></h4>
                    <%
                }
            }
        %>
        
        <%-- isto aqui é um comentário jsp--%>
        <!-- isto é um comentário html-->
    </body>
</html>
