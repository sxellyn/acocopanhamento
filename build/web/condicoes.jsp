<%-- 
    Document   : condicoes
    Created on : Nov 28, 2024, 8:32:22 AM
    Author     : ALUNO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="br.edu.ifpe.recife.model.negocio.CondicaoClinica"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="ifpe"  uri="http://www.ifpe.edu.br/recife/ifpetags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <title>JSP Page</title>

    </head>
    <body>

        <ifpe:hello/>  
        <ifpe:emptyTag attr1="qualquer coisa aqui"
                       data="${java.util.Date.UTC()}">Alguma <i>coisa</i> aqui dentro</ifpe:emptyTag>
        <ifpe:carregaCondicao/>
        <c:forEach begin="1" end="10" step="1" varStatus="i">
            ${i.index}
        </c:forEach>
        
        <h6 style="color: ${(sessionScope.svr eq 'sucesso')?'blue':'red'}">
            ${sessionScope.msg}
        </h6>
            <c:remove var="msg" scope="session"/>
        <%--<%
            List<CondicaoClinica> condicoes = (List<CondicaoClinica>) request.getAttribute("condicoes");
        %>

        
        <h6 style="color: ${(sessionScope.svr eq 'sucesso'?'blue':'red')}"><c:out value="${sessionScope.msg}" escapeXml="true"/></h6>
       
        <c:remove var="msg" scope="session"/>
        
        <c:forEach begin="1" end="10" step="1" varStatus="i">
                ${i.index}
        </c:forEach>
        
        <%--<c:choose>
            <c:when test="${svr eq 'sucess'}">
                
            </c:when>
            <c:when test="${svr eq 'erro'}">
                
            </c:when>
            <c:otherwise>
                
            </c:otherwise>
        </c:choose>
        --%>
        <%--
        <%
            String mensagem = (String) session.getAttribute("msg");
            String severidade = (String) session.getAttribute("svr");

            if (mensagem != null) {
        %>

        <h6 style="color: <%
            if (severidade.equals("sucesso")) {
                out.println("blue");
            } else {
                out.println("red");
            }
            %>"><%= mensagem%></h6>
        <%
                session.removeAttribute("msg");
            }
        %>
        --%>
        <h1>Condições Clínicas cadastradas</h1>
        <button type="button" class="btn btn-success"
                data-bs-toggle="modal" data-bs-target="#modalCadastro">Cadastrar novo registro</button>
        <table class="table">
            <tr>
                <th>Código</th>
                <th>Nome</th>
                <th>Tipo</th>
                <th>data de início</th>
                <th>ações</th>

                <c:forEach var="c" items="${sessionScope.condicoes}">
                <tr>
                    <td>${c.codigo}</td>
                    <td>${c.nome}</td>
                    <td>${c.tipo}</td>
                    <td>${c.dataInicioString}</td>
                    <td><a href="Condicao?codigo=${c.codigo}" >detalhar</a>
                        <a href="Condicao?codigo=${c.codigo}&op=editar">editar</a>
                        <a href="#" class="link-delete" codigo="${c.codigo}">remover</a>
                    </td>
                </tr>
            </c:forEach>
            
                <%--<%
                for (CondicaoClinica c : condicoes) {
            %>

            <tr>
                <td><%= c.getCodigo()%></td>
                <td><%= c.getNome()%></td>
                <td><%= c.getTipo()%></td>
                <td><%= c.getDataInicioString()%></td>
                <td><a href="Condicao?codigo=<%= c.getCodigo()%>" >detalhar</a>
                    <a href="Condicao?codigo=<%= c.getCodigo()%>&op=editar">editar</a>
                    <a href="#" class="link-delete" codigo="<%= c.getCodigo()%>">remover</a>
                </td>
            </tr>



            <% }%>--%>
        </tr>
    </table>


    <div class="modal fade" id="modalCadastro" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Novo Registro</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <%@include file="RegistroCondicao.jsp" %>
                </div>

            </div>
        </div>
    </div>

    <script>


        document.querySelectorAll("[codigo]")
                .forEach(el => {
                    el.addEventListener("click", function (event) {

                        if (window.confirm("tem certeza desta ação?")) {
                            const cod = event.target.getAttribute("codigo")

                            location.href = "Condicao?codigo=" + cod + "&op=remover"
                        }

                    })
                })



    </script>
</body>
</html>
