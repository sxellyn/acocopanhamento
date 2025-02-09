<%-- 
    Document   : indexMedico
    Created on : Jan 8, 2025, 9:42:36 AM
    Author     : kaize
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.ifpe.edu.br/recife/ifpetags" prefix="ifpe"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <jsp:directive.include file="menuMedico.jsp"/>
        <ifpe:carregaPacientes crm="${sessionScope.mLogado.crm}"/>
        <ifpe:carregaCondicao/>

        <c:forEach items="${pageScope.pacientes}" var="paciente">
            <div class="card">
                <div class="card-header">
                    <p class="h3">Paciente: ${paciente.nome}</p>
                </div>
                <div class="card-body">
                    <table class="table">
                        <tr>
                            <th><td  colspan="2">e-mail</td>
                            <td colspan="2">${paciente.email}</td></th>
                        </tr>
                        <tr><th>telefone</th>
                            <td>${paciente.telefone}</td>
                            <th>Data de Nascimento</th>
                            <td>${paciente.dataNascimento}</td>
                        </tr>
                    </table>
                </div>
                <div class="card-footer">
                    <table class="table">
                        <tr>
                            <th>Condições</th>
                            <td>
                                <c:forEach items="${paciente.condicoes}" var="condicao">
                                    <p>${condicao.nome}</p>
                                </c:forEach>
                            </td>
                            <td style="width: 20%">
                                <a href="#" class="btn btn-info" onclick="carregaCondicao(${paciente.cpf}, '${paciente.nome}')">inserir nova condição</a>
                            </td>
                        </tr>
                        <tr>
                            <th>Medicamentos</th>
                            <td>
                                <c:forEach items="${paciente.medicamentos}" var="medicamento">
                                    <p>${medicamento.nome}</p>
                                </c:forEach>
                            </td>
                            <td style="width: 20%">
                                <a href="#" class="btn btn-info">inserir novo medicamento</a>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </c:forEach>

        <div class="modal fade" id="modalCondicao" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Inserir Nova Condição</h5>
                        
                    </div>
                    <div class="modal-body">
                        <form method="post" action="Medico">
                            <input type="hidden" id="hdnCPF" name="cpf" />
                            <input type="hidden" name="op" value="inserirCondicao"/>

                            <p class="h3" id="pNome"></p>
                            <table class="table">
                                <tr>
                                    <th>Condição Clínica:</th>
                                    <td>
                                        <select name="condicao">
                                            <c:forEach items="${pageScope.condicoes}" var="condicao">

                                                <option value="${condicao.codigo}">
                                                    ${condicao.nome}
                                                </option>

                                            </c:forEach>
                                        </select>
                                    </td>
                                </tr>

                            </table>
                            <button class="btn btn-primary" class="btn btn-primary" type="submit">Cadastrar</button>

                        </form>
                    </div>

                </div>
            </div>
        </div>
        
    <script>
        
        const carregaCondicao = function(cpf, nome){
            
            const hdnCpf = document.getElementById("hdnCPF")
            hdnCpf.setAttribute("value", cpf)
            
            const pNome = document.getElementById("pNome")
            pNome.innerHTML = nome
            
            var myModal = new bootstrap.Modal(document.getElementById("modalCondicao"), {});
            myModal.show()
        }
        
        
    </script>


    </body>
</html>
