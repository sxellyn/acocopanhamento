<%-- 
    Document   : indexUsuario
    Created on : Dec 12, 2024, 8:47:33 AM
    Author     : ALUNO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>

        <style>
            html {
                background-color: #56baed;
            }

            body {
                font-family: "Poppins", sans-serif;
                height: 100vh;
            }

            a {
                color: #92badd;
                display:inline-block;
                text-decoration: none;
                font-weight: 400;
            }

            h2 {
                text-align: center;
                font-size: 16px;
                font-weight: 600;
                text-transform: uppercase;
                display:inline-block;
                margin: 40px 8px 10px 8px; 
                color: #cccccc;
            }



            /* STRUCTURE */

            .wrapper {
                display: flex;
                align-items: center;
                flex-direction: column; 
                justify-content: center;
                width: 100%;
                min-height: 100%;
                padding: 20px;
            }

            #formContent {
                -webkit-border-radius: 10px 10px 10px 10px;
                border-radius: 10px 10px 10px 10px;
                background: #fff;
                padding: 30px;
                width: 90%;
                max-width: 450px;
                position: relative;
                padding: 0px;
                -webkit-box-shadow: 0 30px 60px 0 rgba(0,0,0,0.3);
                box-shadow: 0 30px 60px 0 rgba(0,0,0,0.3);
                text-align: center;
            }

            #formFooter {
                background-color: #f6f6f6;
                border-top: 1px solid #dce8f1;
                padding: 25px;
                text-align: center;
                -webkit-border-radius: 0 0 10px 10px;
                border-radius: 0 0 10px 10px;
            }



            /* TABS */

            h2.inactive {
                color: #cccccc;
            }

            h2.active {
                color: #0d0d0d;
                border-bottom: 2px solid #5fbae9;
            }

        </style>

        <title>JSP Page</title>
    </head>
    <body style="background-color: floralwhite">

        <c:if test="${sessionScope.uLogado ne null}">
            <c:redirect url="indexUsuario.jsp"/>
        </c:if>



        <h6 style="color: ${(sessionScope.svr eq 'sucesso')?'blue':'red'}">
            ${sessionScope.msg}
        </h6>
        <c:remove var="msg" scope="session"/>

        <div class="wrapper fadeInDown">
            <div id="formContent">
                <!-- Tabs Titles -->

                <!-- Icon -->
                <div class="fadeIn first">
                    <p class="h4">Faça login como usuário</p>
                </div>

                <!-- Login Form -->
                <form method="post" action="Usuario">
                    <input type="hidden" name="op" value="login"/>
                    <input type="text" id="email" class="fadeIn second form-control" name="email" placeholder="login"/>
                    <input type="password" id="senha" class="fadeIn third form-control" name="senha" placeholder="password"/>
                    <input type="submit" class="fadeIn fourth btn btn-primary" value="Log In"/>
                </form>

                <!-- Remind Passowrd -->
                <div id="formFooter">
                    <span>Não é registrado <a class="underlineHover" 
                                              data-toggle="modal" data-target="#modalCadastro"
                                              href="#">registre-se</a></span>
                </div>

            </div>
        </div>

        <div class="modal fade" id="modalCadastro" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Registre-se</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form method="post" action="Usuario">
                            <table class="table">
                                <tr>
                                    <th>CPF:</th>
                                    <td><input type="text" name="cpf" class="form-control"/></td>
                                </tr>
                                <tr>
                                    <th>Nome:</th>
                                    <td><input type="text" name="nome" class="form-control"/></td>
                                </tr>
                                <tr>
                                    <th>e-mail:</th>
                                    <td><input type="text" name="email" class="form-control"/></td>
                                </tr>
                                <tr>
                                    <th>Telefone:</th>
                                    <td><input type="text" name="telefone" class="form-control"/></td>
                                </tr>
                                <tr>
                                    <th>Localidade:</th>
                                    <td><input type="text" name="localidade" class="form-control"/></td>
                                </tr>
                                <tr>
                                    <th>Data de Nascimento:</th>
                                    <td><input type="text" name="nascimento" class="form-control"/></td>
                                </tr>
                                <tr>
                                    <th>senha:</th>
                                    <td><input type="password" name="senha" class="form-control"/></td>
                                </tr>
                                <tr>
                                    <th>Confirmação:</th>
                                    <td><input type="password" name="confirma" class="form-control"/></td>
                                </tr>
                            </table>
                            <button class="btn btn-primary" class="btn btn-primary" type="submit">Cadastrar</button>

                        </form>
                    </div>

                </div>
            </div>
        </div>


    </body>
</html>
