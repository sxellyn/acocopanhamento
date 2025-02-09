<%-- 
    Document   : RegistroMedicamento
    Created on : Nov 27, 2024, 11:19:31 AM
    Author     : ALUNO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous"/>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        
        <title>JSP Page</title>
    </head>
    
    <body>
        <h1>${(param['op'] eq 'editar')?'editar':'Cadastro de nova'} condição!</h1>
        <a href="index.html" class="link-offset-2 link-underline link-underline-opacity-0">voltar</a>
        <form method="post" action="Condicao">

            ${(param['op'] eq 'editar')?'<input type="hidden" name="op" value="editar"/>':''}
            <table class="table">
                <tr>
                    <th>
                        Código:
                    </th>
                    <td>
                        <input type="text" name="codigo" 
                               ${(param['op'] eq 'editar')?'readonly="true"':''} 
                               ${(param['op'] eq 'editar')?'value="'.concat(requestScope.condicao.codigo).concat('"'):''} class="form-control"/>
                    </td>
                </tr>
                <tr>
                    <th>
                        Nome:
                    </th>
                    <td>
                        <input type="text" name="nome" class="form-control"
                               value="${(param['op'] eq 'editar')?requestScope.condicao.nome:''}"/>
                    </td>
                </tr>
                <tr>
                    <th>
                        Tipo:
                    </th>
                    <td>
                        <input type="text" name="tipo" class="form-control"
                               value="${(param['op'] eq 'editar')?requestScope.condicao.tipo:''}"/>
                    </td>
                </tr>
                <tr>
                    <th>
                        Data de Inicio:
                    </th>
                    <td>
                        <input type="text" name="data" class="form-control"
                               value="${(param['op'] eq 'editar')?requestScope.condicao.dataInicioString:''}"/>
                    </td>
                </tr>
                <tr>
                    <th>
                        Observação:
                    </th>
                    <td>
                        <textarea name="obs" class="form-control">${(param['op'] eq 'editar')?requestScope.condicao.nome:''}</textarea>
                    </td>
                </tr>
            </table>
            <button type="submit" class="btn btn-primary">${(param['op'] eq 'editar')?'editar':'cadastrar'}</button>
        </form>
    </body>
</html>
