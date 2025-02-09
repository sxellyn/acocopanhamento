<%-- 
    Document   : perfilMedico
    Created on : Jan 8, 2025, 9:51:35 AM
    Author     : kaize
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

    <center>
        <table class="table" style="width: 60%">
            <tr>
                <td style="width: 30%">
                    <a href="#" data-bs-toggle="modal" data-bs-target="#modalAltera">alterar dados cadastrais</a><br/>
                    <a href="#" data-bs-toggle="modal" data-bs-target="#modalAlteraSenha">alterar senha</a>
                </td>
                <td >
                    <table class="table">
                        <tr>
                            <th>CRM:</th>
                            <td>${sessionScope.mLogado.crm}</td>
                        </tr>
                        <tr>
                            <th>Nome:</th>
                            <td>${sessionScope.mLogado.nome}</td>
                        </tr>
                        <tr>
                            <th>Especialidade:</th>
                            <td>${sessionScope.mLogado.especialidade}</td>
                        </tr>
                        <tr>
                            <th>Contato:</th>
                            <td>${sessionScope.mLogado.contato}</td>
                        </tr>
                    </table>
                </td>
            </tr>


        </table>

    </center>

    <div class="modal fade" id="modalAltera" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">edite seus dados</h5>

                </div>
                <div class="modal-body">
                    <form method="post" action="Medico">
                        <input type="hidden" name="op" value="editar"/>
                        <table class="table">
                            <tr>
                                <th>CRM:</th>
                                <td><input type="text" name="crm" class="form-control"
                                           value="${sessionScope.mLogado.crm}" readonly="true"/></td>
                            </tr>
                            <tr>
                                <th>Nome:</th>
                                <td><input type="text" name="nome" class="form-control"
                                           value="${sessionScope.mLogado.nome}"/></td>
                            </tr>
                            <tr>
                                <th>Especialidade:</th>
                                <td><input type="text" name="especialidade" class="form-control"
                                           value="${sessionScope.mLogado.especialidade}"/></td>
                            </tr>
                            <tr>
                                <th>Contato:</th>
                                <td><input type="text" name="contato" class="form-control"
                                           value="${sessionScope.mLogado.contato}"/></td>
                            </tr>


                        </table>
                        <button class="btn btn-primary" class="btn btn-primary" type="submit">editar</button>

                    </form>
                </div>

            </div>
        </div>
    </div>

    <div class="modal fade" id="modalAlteraSenha" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">edite sua senha</h5>

                </div>
                <div class="modal-body">
                    <form method="post" action="Medico">
                        <input type="hidden" name="op" value="senha"/>
                        <table class="table">
                            <tr>
                                <th>Senha Atual:</th>
                                <td><input type="password" name="atual" class="form-control"
                                           /></td>
                            </tr>
                            <tr>
                                <th>Nova Senha:</th>
                                <td><input type="password" name="nova" class="form-control"/></td>
                            </tr>
                            <tr>
                                <th>Confirmação da nova senha:</th>
                                <td><input type="password" name="confirma" class="form-control"
                                           /></td>
                            </tr>


                        </table>
                        <button class="btn btn-primary" class="btn btn-primary" type="submit">editar</button>

                    </form>
                </div>

            </div>
        </div>
    </div>
</body>
</html>
