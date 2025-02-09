<%-- 
    Document   : perfilUsuario
    Created on : Dec 19, 2024, 8:27:38 AM
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

        <jsp:directive.include file="menuUsuario.jsp"/>
    <center>
        <table class="table" style="width: 60%">
            <tr>
                <td style="width: 30%">
                    <a href="#" data-bs-toggle="modal" data-bs-target="#modalAltera">alterar dados cadastrais</a><br/>
                    <a href="#">alterar senha</a>
                </td>
                <td >
                    <table class="table">
                        <tr>
                            <th>CPF:</th>
                            <td>${sessionScope.uLogado.cpf}</td>
                        </tr>
                        <tr>
                            <th>Nome:</th>
                            <td>${sessionScope.uLogado.nome}</td>
                        </tr>
                        <tr>
                            <th>e-mail:</th>
                            <td>${sessionScope.uLogado.email}</td>
                        </tr>
                        <tr>
                            <th>Telefone:</th>
                            <td>${sessionScope.uLogado.telefone}</td>
                        </tr>
                        <tr>
                            <th>Localidade:</th>
                            <td>${sessionScope.uLogado.localidade}</td>
                        </tr>
                        <tr>
                            <th>Data de Nascimento:</th>
                            <td>${sessionScope.uLogado.dataNascimento}</td>
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
                        <form method="post" action="Usuario">
                            <input type="hidden" name="op" value="editar"/>
                            <table class="table">
                                <tr>
                                    <th>CPF:</th>
                                    <td><input type="text" name="cpf" class="form-control"
                                               value="${sessionScope.uLogado.cpf}" readonly="true"/></td>
                                </tr>
                                <tr>
                                    <th>Nome:</th>
                                    <td><input type="text" name="nome" class="form-control"
                                               value="${sessionScope.uLogado.nome}"/></td>
                                </tr>
                                <tr>
                                    <th>e-mail:</th>
                                    <td><input type="text" name="email" class="form-control"
                                               value="${sessionScope.uLogado.email}"/></td>
                                </tr>
                                <tr>
                                    <th>Telefone:</th>
                                    <td><input type="text" name="telefone" class="form-control"
                                               value="${sessionScope.uLogado.telefone}"/></td>
                                </tr>
                                <tr>
                                    <th>Localidade:</th>
                                    <td><input type="text" name="localidade" class="form-control"
                                               value="${sessionScope.uLogado.localidade}"/></td>
                                </tr>
                                <tr>
                                    <th>Data de Nascimento:</th>
                                    <td><input type="text" name="nascimento" class="form-control"
                                               value="${sessionScope.uLogado.dataNascimento}"/></td>
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
