package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import br.edu.ifpe.recife.model.negocio.CondicaoClinica;
import java.util.List;

public final class condicoesJS_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/RegistroCondicao.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        ");

            List<CondicaoClinica> condicoes = (List<CondicaoClinica>) session.getAttribute("condicoes");
        
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        ");

            String mensagem = (String) session.getAttribute("msg");
            String severidade = (String) session.getAttribute("svr");

            if (mensagem != null) {
        
      out.write("\n");
      out.write("\n");
      out.write("        <h6 style=\"color: ");

            if (severidade.equals("sucesso")) {
                out.println("blue");
            } else {
                out.println("red");
            }
            
      out.write('"');
      out.write('>');
      out.print( mensagem);
      out.write("</h6>\n");
      out.write("        ");

                session.removeAttribute("msg");
            }
        
      out.write("\n");
      out.write("        <h1>Condições Clínicas cadastradas</h1>\n");
      out.write("        <button type=\"button\" class=\"btn btn-success\"\n");
      out.write("                data-bs-toggle=\"modal\" data-bs-target=\"#modalCadastro\">Cadastrar novo registro</button>\n");
      out.write("        <table class=\"table\">\n");
      out.write("            <tr>\n");
      out.write("                <th>Código</th>\n");
      out.write("                <th>Nome</th>\n");
      out.write("                <th>Tipo</th>\n");
      out.write("                <th>data de início</th>\n");
      out.write("                <th>ações</th>\n");
      out.write("                    ");

                        for (CondicaoClinica c : condicoes) {
                    
      out.write("\n");
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print( c.getCodigo());
      out.write("</td>\n");
      out.write("                <td>");
      out.print( c.getNome());
      out.write("</td>\n");
      out.write("                <td>");
      out.print( c.getTipo());
      out.write("</td>\n");
      out.write("                <td>");
      out.print( c.getDataInicioString());
      out.write("</td>\n");
      out.write("                <td><a href=\"#\" codigoDetalhe=\"");
      out.print( c.getCodigo());
      out.write("\" >detalhar</a>\n");
      out.write("                    <a href=\"Condicao?codigo=");
      out.print( c.getCodigo());
      out.write("&op=editar\">editar</a>\n");
      out.write("                    <a href=\"#\" class=\"link-delete\" codigo=\"");
      out.print( c.getCodigo());
      out.write("\">remover</a>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("\n");
      out.write("            ");
 }
      out.write("\n");
      out.write("        </tr>\n");
      out.write("    </table>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <div class=\"modal fade\" id=\"modalCadastro\" tabindex=\"-1\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("        <div class=\"modal-dialog\">\n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("                <div class=\"modal-header\">\n");
      out.write("                    <h5 class=\"modal-title\" id=\"exampleModalLabel\">Novo Registro</h5>\n");
      out.write("                    <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-body\">\n");
      out.write("                    ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\"/>\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM\" crossorigin=\"anonymous\"></script>\n");
      out.write("        \n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("        <h1>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${(param['op'] eq 'editar')?'editar':'Cadastro de nova'}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" condição!</h1>\n");
      out.write("        <a href=\"index.html\" class=\"link-offset-2 link-underline link-underline-opacity-0\">voltar</a>\n");
      out.write("        <form method=\"post\" action=\"Condicao\">\n");
      out.write("\n");
      out.write("            ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${(param['op'] eq 'editar')?'<input type=\"hidden\" name=\"op\" value=\"editar\"/>':''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("            <table class=\"table\">\n");
      out.write("                <tr>\n");
      out.write("                    <th>\n");
      out.write("                        Código:\n");
      out.write("                    </th>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"text\" name=\"codigo\" \n");
      out.write("                               ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${(param['op'] eq 'editar')?'readonly=\"true\"':''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" \n");
      out.write("                               ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${(param['op'] eq 'editar')?'value=\"'.concat(requestScope.condicao.codigo).concat('\"'):''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" class=\"form-control\"/>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <th>\n");
      out.write("                        Nome:\n");
      out.write("                    </th>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"text\" name=\"nome\" class=\"form-control\"\n");
      out.write("                               value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${(param['op'] eq 'editar')?requestScope.condicao.nome:''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <th>\n");
      out.write("                        Tipo:\n");
      out.write("                    </th>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"text\" name=\"tipo\" class=\"form-control\"\n");
      out.write("                               value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${(param['op'] eq 'editar')?requestScope.condicao.tipo:''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <th>\n");
      out.write("                        Data de Inicio:\n");
      out.write("                    </th>\n");
      out.write("                    <td>\n");
      out.write("                        <input type=\"text\" name=\"data\" class=\"form-control\"\n");
      out.write("                               value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${(param['op'] eq 'editar')?requestScope.condicao.dataInicioString:''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <th>\n");
      out.write("                        Observação:\n");
      out.write("                    </th>\n");
      out.write("                    <td>\n");
      out.write("                        <textarea name=\"obs\" class=\"form-control\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${(param['op'] eq 'editar')?requestScope.condicao.nome:''}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</textarea>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("            <button type=\"submit\" class=\"btn btn-primary\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${(param['op'] eq 'editar')?'editar':'cadastrar'}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</button>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"modal fade\" id=\"modalDetalhe\" tabindex=\"-1\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("        <div class=\"modal-dialog\">\n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("                <div class=\"modal-header\">\n");
      out.write("                    <h5 class=\"modal-title\" id=\"exampleModalLabel\">Novo Registro</h5>\n");
      out.write("                    <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"modal\" aria-label=\"Close\"></button>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-body\">\n");
      out.write("                    <table class=\"table\">\n");
      out.write("                        <tr>\n");
      out.write("                            <th>Código</th>\n");
      out.write("                            <td><div id=\"divCodigo\"></div></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>Nome</th>\n");
      out.write("                            <td><div id=\"divNome\"></div></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>Tipo</th>\n");
      out.write("                            <td><div id=\"divTipo\"></div></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>Data de Início</th>\n");
      out.write("                            <td><div id=\"divInicio\"></div></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <th>Observação</th>\n");
      out.write("                            <td><div id=\"divObs\"></div></td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <script>\n");
      out.write("\n");
      out.write("\n");
      out.write("        document.querySelectorAll(\"[codigo]\")\n");
      out.write("                .forEach(el => {\n");
      out.write("                    el.addEventListener(\"click\", function (event) {\n");
      out.write("\n");
      out.write("                        if (window.confirm(\"tem certeza desta ação?\")) {\n");
      out.write("                            const cod = event.target.getAttribute(\"codigo\")\n");
      out.write("\n");
      out.write("                            location.href = \"Condicao?codigo=\" + cod + \"&op=remover\"\n");
      out.write("                        }\n");
      out.write("\n");
      out.write("                    })\n");
      out.write("                })\n");
      out.write("\n");
      out.write("        document.querySelectorAll(\"[codigoDetalhe]\")\n");
      out.write("                .forEach(el => {\n");
      out.write("                    el.addEventListener(\"click\",\n");
      out.write("                            function (event) {\n");
      out.write("\n");
      out.write("                                const xhttp = new XMLHttpRequest();\n");
      out.write("                                xhttp.onload = function () {\n");
      out.write("\n");
      out.write("                                    const json = JSON.parse(this.responseText);\n");
      out.write("                                    \n");
      out.write("                                    console.log(json)\n");
      out.write("                                    \n");
      out.write("                                    document.getElementById(\"divCodigo\").innerHTML = json.codigo;\n");
      out.write("                                    document.getElementById(\"divNome\").innerHTML = json.nome;\n");
      out.write("                                    document.getElementById(\"divTipo\").innerHTML = json.tipo;\n");
      out.write("                                    document.getElementById(\"divInicio\").innerHTML = json.dataInicio;\n");
      out.write("                                    document.getElementById(\"divObs\").innerHTML = json.observacao;\n");
      out.write("\n");
      out.write("                                    var galleryModal = new bootstrap.Modal(document.getElementById('modalDetalhe'), {\n");
      out.write("                                        keyboard: false\n");
      out.write("                                    });\n");
      out.write("\n");
      out.write("\n");
      out.write("                                    galleryModal.show();\n");
      out.write("                                }\n");
      out.write("\n");
      out.write("                                const codigo = event.target.getAttribute(\"codigoDetalhe\")\n");
      out.write("\n");
      out.write("                                xhttp.open(\"GET\", \"CondicaoJS?codigo=\" + codigo);\n");
      out.write("                                xhttp.send();\n");
      out.write("\n");
      out.write("                            })\n");
      out.write("                })\n");
      out.write("\n");
      out.write("    </script>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
