/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.controllers;

import br.edu.ifpe.recife.model.negocio.CondicaoClinica;
import br.edu.ifpe.recife.model.repositorios.RepositorioCondicaoClinica;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ALUNO
 */
@WebServlet(name = "CondicaoController", urlPatterns = {"/Condicao"})
public class CondicaoController extends HttpServlet {

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

            String op = request.getParameter("op");
            
            if(op!=null && op.equals("remover")){
                
                RepositorioCondicaoClinica.deletar(Integer.parseInt(codigo));
                
                request.getSession().setAttribute("msg", "Registro Deletado com Sucesso!");
                request.getSession().setAttribute("svr", "sucesso");
                
                response.sendRedirect("Condicao");
                
                return;
                
            }

            CondicaoClinica condicao = RepositorioCondicaoClinica
                    .ler(Integer.parseInt(codigo));

            request.setAttribute("condicao", condicao);

            if (op != null && op.equals("editar")) {
                getServletContext().getRequestDispatcher("/RegistroCondicao.jsp")
                        .forward(request, response);
            } else {
                getServletContext().getRequestDispatcher("/detalheCondicao.jsp")
                        .forward(request, response);
            }

            return;

        }

        List<CondicaoClinica> condicoes = RepositorioCondicaoClinica.lerTudo();

        request.getSession().setAttribute("condicoes", condicoes);
        

        response.sendRedirect("condicoes.jsp");

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
        try {
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            String nome = request.getParameter("nome");
            String tipo = request.getParameter("tipo");
            String data = request.getParameter("data");
            String obs = request.getParameter("obs");

            CondicaoClinica condicao = new CondicaoClinica();

            condicao.setCodigo(codigo);

            condicao.setDataInicioString(data);

            condicao.setNome(nome);
            condicao.setTipo(tipo);
            condicao.setObservacao(obs);

            String op = request.getParameter("op");

            HttpSession session = request.getSession();

            if (op != null && op.equals("editar")) {
                RepositorioCondicaoClinica.alterar(condicao);

                session.setAttribute("msg", "Registro editado com sucesso!");

            } else {
                RepositorioCondicaoClinica.inserir(condicao);
                session.setAttribute("msg", "Registro cadastrado com sucesso!");

            }

            session.setAttribute("svr", "sucesso");

            response.sendRedirect("Condicao");
        } catch (ParseException ex) {
            HttpSession session = request.getSession();
            session.setAttribute("msg", "Você digitou a data no formato errado!"
                    + "O formato correto é dd/mm/aaaa. Por favor não cometa este erro denovo");
            session.setAttribute("svr", "erro");

            response.sendRedirect("Condicao");
        } catch (NumberFormatException number) {
            HttpSession session = request.getSession();
            session.setAttribute("msg", "O código que você digitou, não é um número");
            session.setAttribute("svr", "erro");

            response.sendRedirect("Condicao");
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
