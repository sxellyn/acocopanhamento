/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.controllers;

import br.edu.ifpe.recife.model.negocio.Medicamento;
import br.edu.ifpe.recife.model.repositorios.RepositorioMedicamento;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ALUNO
 */
public class MedicamentoController extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String codigo = request.getParameter("codigo");

        if (codigo != null) {

            int cInt = Integer.parseInt(codigo);

            Medicamento m = RepositorioMedicamento.ler(cInt);

            String operacao = request.getParameter("op");

            if (operacao != null && operacao.equals("deletar")) {

                RepositorioMedicamento.delete(cInt);

                response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter out = response.getWriter()) {
                    /* TODO output your page here. You may use following sample code. */
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet MedicamentoController</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Medicamento deletado com sucesso</h1>");
                    out.println("<a href='Medicamentos'>ir para medicamentos</a>");

                    out.println("</table>");
                    out.println("</body>");
                    out.println("</html>");
                }
                return;

            }

            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet MedicamentoController</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Edita Medicamento</h1>");
                out.println("<a href='Medicamentos'>voltar</a>");

                String s = "<form method=\"post\" action=\"Medicamentos\">\n"
                        + "            Código: <input type=\"number\" readonly name=\"codigo\" value='" + m.getCodigo() + "'/><br/>\n"
                        + "            Nome: <input type=\"text\" name=\"nome\" value='" + m.getNome() + "'/></br>\n"
                        + "            Princípio Ativo: <input type=\"text\" name=\"princ\" value='" + m.getPrincipioAtivo() + "'/></br>\n"
                        + "            Dosagem: <input type=\"text\" name=\"dosagem\" value='" + m.getDosagem() + "'/></br>\n"
                        + "            <input type=\"submit\" value=\"Editar\"/>\n"
                        + "        </form>";

                out.println(s);

                out.println("</table>");
                out.println("</body>");
                out.println("</html>");
            }
            return;
        }

        List<Medicamento> medicamentos = RepositorioMedicamento
                .lerTudo();

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MedicamentoController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Medicamentos cadastrados em nossa base de dados</h1>");
            out.println("<a href='cadastroMedicamento.html'>cadastrar novo medicamento</a>");
            out.println("<table border=\"1\">");
            out.println("<tr><th>Código</th><th>Nome</th><th>Principio Ativo</th><th>Dosagem</th>"
                    + "<th>acoes</th></tr>");

            for (Medicamento m : medicamentos) {
                out.println("<tr>");
                out.println("<td>" + m.getCodigo() + "</td>");
                out.println("<td>" + m.getNome() + "</td>");
                out.println("<td>" + m.getPrincipioAtivo() + "</td>");
                out.println("<td>" + m.getDosagem() + "</td>");
                out.println("<td><a href='Medicamentos?codigo=" + m.getCodigo() + "'>editar</a> "
                        + "<a href='Medicamentos?codigo=" + m.getCodigo() + "&op=deletar'>deletar</a></td>");
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int codigo = Integer.parseInt(request.getParameter("codigo"));
        String nome = request.getParameter("nome");
        String principio = request.getParameter("princ");
        String dosagem = request.getParameter("dosagem");

        Medicamento m = new Medicamento();

        m.setCodigo(codigo);
        m.setNome(nome);
        m.setPrincipioAtivo(principio);
        m.setDosagem(dosagem);

        RepositorioMedicamento.alterar(m);

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CadastroMedicamentoServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Medicamento " + m.getNome() + " alterado com sucesso</h1>");
            out.println("<a href='Medicamentos'>cadastrar novo medicamento</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
