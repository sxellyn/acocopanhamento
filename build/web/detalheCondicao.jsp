<%-- 
    Document   : detalheCondicao
    Created on : Dec 4, 2024, 10:53:25 AM
    Author     : ALUNO
--%>

<%@page import="br.edu.ifpe.recife.model.negocio.CondicaoClinica"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    </head>
    <body>
        <h1>Detalhes da condição clínica</h1>
        <a href="Condicao">voltar</a>

        <table class="table">
            <tr>
                <th>
                    Código:
                </th>
                <td>
                    ${requestScope.condicao.codigo}
                </td>
            </tr>
            <tr>
                <th>
                    Nome:
                </th>
                <td>
                    ${requestScope.condicao.nome}
                </td>
            </tr>
            <tr>
                <th>
                    Tipo:
                </th>
                <td>
                    ${requestScope.condicao.tipo}
                </td>
            </tr>
            <tr>
                <th>
                    Data de Início:
                </th>
                <td>
                    ${requestScope.condicao.dataInicioString}
                </td>
            </tr>
            <tr>
                <th>
                    Descrição:
                </th>
                <td>
                    ${requestScope.condicao.observacao}
                </td>
            </tr>
        </table>
    </body>
</html>
