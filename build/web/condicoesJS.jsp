<%-- 
    Document   : condicoesJS
    Created on : Dec 5, 2024, 8:45:26 AM
    Author     : ALUNO
--%>

<%@page import="br.edu.ifpe.recife.model.negocio.CondicaoClinica"%>
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
            List<CondicaoClinica> condicoes = (List<CondicaoClinica>) session.getAttribute("condicoes");
        %>


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
            </tr>
                    <%
                        for (CondicaoClinica c : condicoes) {
                    %>

            <tr>
                <td><%= c.getCodigo()%></td>
                <td><%= c.getNome()%></td>
                <td><%= c.getTipo()%></td>
                <td><%= c.getDataInicioString()%></td>
                <td><a href="#" codigoDetalhe="<%= c.getCodigo()%>" >detalhar</a>
                    <a href="Condicao?codigo=<%= c.getCodigo()%>&op=editar">editar</a>
                    <a href="#" class="link-delete" codigo="<%= c.getCodigo()%>">remover</a>
                </td>
            </tr>

            <% }%>
        
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

    <div class="modal fade" id="modalDetalhe" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Novo Registro</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <table class="table">
                        <tr>
                            <th>Código</th>
                            <td><div id="divCodigo"></div></td>
                        </tr>
                        <tr>
                            <th>Nome</th>
                            <td><div id="divNome"></div></td>
                        </tr>
                        <tr>
                            <th>Tipo</th>
                            <td><div id="divTipo"></div></td>
                        </tr>
                        <tr>
                            <th>Data de Início</th>
                            <td><div id="divInicio"></div></td>
                        </tr>
                        <tr>
                            <th>Observação</th>
                            <td><div id="divObs"></div></td>
                        </tr>
                    </table>
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

        document.querySelectorAll("[codigoDetalhe]")
                .forEach(el => {
                    el.addEventListener("click",
                            function (event) {

                                const xhttp = new XMLHttpRequest();
                                xhttp.onload = function () {

                                    const json = JSON.parse(this.responseText);
                                    
                                    console.log(json)
                                    
                                    document.getElementById("divCodigo").innerHTML = json.codigo;
                                    document.getElementById("divNome").innerHTML = json.nome;
                                    document.getElementById("divTipo").innerHTML = json.tipo;
                                    document.getElementById("divInicio").innerHTML = json.dataInicio;
                                    document.getElementById("divObs").innerHTML = json.observacao;

                                    var galleryModal = new bootstrap.Modal(document.getElementById('modalDetalhe'), {
                                        keyboard: false
                                    });


                                    galleryModal.show();
                                }

                                const codigo = event.target.getAttribute("codigoDetalhe")

                                xhttp.open("GET", "CondicaoJS?codigo=" + codigo);
                                xhttp.send();

                            })
                })

    </script>
</html>
