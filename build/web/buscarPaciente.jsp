<%-- 
    Document   : buscarPaciente
    Created on : Jan 23, 2025, 8:10:47 AM
    Author     : ALUNO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <jsp:directive.include file="menuMedico.jsp"/>

        <h1>Procure as informações de um paciente</h1>
        <form method="get" action="Usuario">

            <input type="hidden" name="op" value="buscarPMedico"/>
            <div class="h3">CPF do paciente:</div>
            <input type="text" name="cpf" class="form-control"/>
            <button type="submit" class="btn btn-success">buscar</button>
        </form>

        <div>
            <c:choose>
                <c:when test="${requestScope.paciente eq null}">
                    <small>busque um paciente</small>
                </c:when>
                <c:otherwise>
                    <form method="post" action="Medico">
                        <input type="hidden" name="op" value="acompanhar"/>
                        <input type="hidden" name="cpf" 
                               value="${requestScope.paciente.cpf}"/>
                        <button type="submit" class="btn btn-info">
                            Acompanhar este paciente
                        </button>
                    </form>
                    <table class="table">
                        <tr>
                            <th>Cpf:</th>
                            <td>${requestScope.paciente.cpf}</td>
                        <tr>
                        <tr>
                            <th>Nome:</th>
                            <td>${requestScope.paciente.nome}</td>
                        </tr>
                        <tr>
                            <th>e-mail:</th>
                            <td>${requestScope.paciente.email}</td>
                        </tr>
                        <tr>
                            <th>Telefone:</th>
                            <td>${requestScope.paciente.telefone}</td>
                        </tr>
                        <tr>
                            <th>Localidade:</th>
                            <td>${requestScope.paciente.localidade}</td>
                        </tr>
                        <tr>
                            <th>Data de Nascimento:</th>
                            <td>${requestScope.paciente.dataNascimento}</td>
                        </tr>
                        <tr>
                            <th>Médicos que acompanham este paciente</th>
                            <td>
                                <c:forEach var="medico" items="${requestScope.paciente.medicoAcompanhante}">
                                    <p>${medico.crm} - ${medico.nome}</p>
                                </c:forEach>
                            </td>
                        </tr>
                        <tr>
                            <th>Condições Clínicas</th>
                            <td>
                                <c:forEach var="condicao" items="${requestScope.paciente.condicoes}">
                                    <p>${condicao.nome}</p>
                                </c:forEach>
                            </td>
                        </tr>
                        <tr>
                            <th>Medicamentos</th>
                            <td>
                                <c:forEach var="medicamento" items="${requestScope.paciente.medicamentos}">
                                    <p>${medicamento.nome}</p>
                                </c:forEach>
                            </td>
                        </tr>

                    </table>
                </c:otherwise>
            </c:choose>

        </div>
    </body>
</html>
