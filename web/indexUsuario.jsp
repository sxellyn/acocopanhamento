<%-- 
    Document   : indexUsuario
    Created on : Dec 18, 2024, 11:03:51 AMD
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
        
        <c:forEach items="${uLogado.evacoacoes}" var="evac" varStatus="i">
            <div class="card">
            
            <div class="card-header">
                Data da Evacuação: ${evac.dataFormatada}
            </div>
            
            <table class="table">
                <tr>
                    <td><p>Aspecto: ${evac.aspecto}</p>
                        <p>Xêro: ${evac.intensidadeCheiro}</p></td>
                    <td>
                        <img style="width: 600px" src="CarregaImagem?indice=${i.index}"
                        
                    </td>
                </tr>
            </table>
            
        </div>
        </c:forEach>
        
        

        <a href="#" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#modalEvacuacao">Registro de nova evacuação</a>

        <div class="modal fade" id="modalEvacuacao" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Inserir nova evacuação</h5>

                    </div>
                    <div class="modal-body">
                        <form method="post" action="Usuario" enctype="multipart/form-data">
                            <input type="hidden" name="op" value="nEvacuacao"/>
                            
                            <table class="table">
                                
                                <tr>
                                    <th>Aspecto:</th>
                                    <td><input type="text" name="aspecto" class="form-control"/></td>
                                </tr>
                                 <tr>
                                    <th>Cor:</th>
                                    <td><input type="text" name="cor" class="form-control"/></td>
                                </tr>
                                 <tr>
                                    <th>Intensidade da dor:</th>
                                    <td><select name="intensidadeDor" class="form-control">
                                            <option value="sem dor">sem dor</option>
                                            <option value="fraca">fraca</option>
                                            <option value="moderada">moderada</option>
                                            <option value="forte">forte</option>
                                            <option value="ai meu Deus">ai meu Deus, que dor da peste!</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Presença de Sangue:</th>
                                    <td><select name="sangue"class="form-control">
                                            <option value="não">nao</option>
                                            <option value="sim">sim</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Intensidade do xêro:</th>
                                    <td><select name="intensidadeXero" class="form-control">
                                            <option value="sem xêro">sem xêro</option>
                                            <option value="fraca">fraca</option>
                                            <option value="moderada">moderada</option>
                                            <option value="forte">forte</option>
                                            <option value="que fedor">ai meu Deus, que fedor da peste!</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Volume:</th>
                                    <td><select name="volume" class="form-control">
                                            <option value="pouco">pouco</option>
                                            <option value="moderada">moderada</option>
                                            <option value="muito">muito</option>
                                            <option value="entupiu o vado">entupiu o vaso!</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <th>Foto do vaso:</th>
                                    <td>
                                        <input type="file" name="foto" class="form-control"/>
                                    </td>
                                </tr>
                            </table>
                            <button type="submit" class="btn btn-primary">enviar a merda</button>
                        </form>
                    </div>

                </div>
            </div>
        </div>
    <tBody></tbody>
</body>
</html>
