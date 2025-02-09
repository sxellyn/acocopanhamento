/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.controllers;

import br.edu.ifpe.recife.model.negocio.Evacuada;
import br.edu.ifpe.recife.model.negocio.Usuario;
import br.edu.ifpe.recife.model.repositorios.RepositorioUsuario;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author ALUNO
 */
@WebServlet(name = "UsuarioController", urlPatterns = {"/Usuario"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024, // 1MB
        maxFileSize = 1024 * 1024 * 4, // 4MB
        maxRequestSize = 1024 * 1024 * 4 // 4MB

)
public class UsuarioController extends HttpServlet {

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

        String operacao = request.getParameter("op");

        if (operacao != null && operacao.equals("logout")) {

            request.getSession().removeAttribute("uLogado");
            //O código abaixo serve para remover todos os atributos da sessão
            //request.getSession().invalidate();

            response.sendRedirect("loginUsuario.jsp");

            return;

        }

        if (operacao != null && operacao.equals("buscarPMedico")) {

            String cpf = request.getParameter("cpf");

            Usuario p = RepositorioUsuario.read(Long.parseLong(cpf));

            if (p == null) {
                request.getSession().setAttribute("msg",
                        "paciente não encontrado!");

                request.getSession().setAttribute("svd", "erro");
            }

            request.setAttribute("paciente", p);

            getServletContext().getRequestDispatcher("/buscarPaciente.jsp")
                    .forward(request, response);

            return;
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

        String operacao = request.getParameter("op");

        if (operacao != null && operacao.equals("nEvacuacao")) {

            Usuario logado = (Usuario) request.getSession().getAttribute("uLogado");

            String aspecto = request.getParameter("aspecto");
            String cor = request.getParameter("cor");
            String intensidade = request.getParameter("intensidadeDor");
            String sangue = request.getParameter("sangue");
            String xero = request.getParameter("intensidadeXero");
            String volume = request.getParameter("volume");

            Part p = request.getPart("foto");

            byte[] imagem = new byte[(int) p.getSize()];

            p.getInputStream().read(imagem);

            Evacuada evac = new Evacuada();

            evac.setAspecto(aspecto);
            evac.setCor(cor);
            evac.setData(System.currentTimeMillis());
            evac.setImagem(imagem);
            evac.setIntensidadeCheiro(xero);
            evac.setIntensidadeDor(intensidade);
            evac.setSanguePresente(sangue.equals("sim"));
            evac.setVolume(volume);

            logado.getEvacoacoes().add(evac);

            RepositorioUsuario.alterar(logado);

            request.getSession().setAttribute("msg", "Cagada inserida com sucesso!");
            request.getSession().setAttribute("svr", "sucesso");

            response.sendRedirect("indexUsuario.jsp");
            
            return;

        }

        if (operacao != null && operacao.equals("login")) {

            String email = request.getParameter("email");
            String senha = request.getParameter("senha");

            try {
                Usuario logado = RepositorioUsuario.login(email, senha);

                if (logado == null) {
                    request.getSession().setAttribute("msg", "Não foi possível realizar o login!");
                    request.getSession().setAttribute("svr", "erro");

                    response.sendRedirect("loginUsuario.jsp");

                    return;
                }

                /*Cookie c = new Cookie("idUsuario", logado.getCpf()+"");
                c.setMaxAge(3600/2);
                response.addCookie(c);*/
                request.getSession().setAttribute("uLogado", logado);

                response.sendRedirect("indexUsuario.jsp");

                return;

            } catch (NoSuchAlgorithmException ex) {
                request.getSession().setAttribute("msg", "Não foi possível realizar o login!");
                request.getSession().setAttribute("svr", "erro");

                response.sendRedirect("loginUsuario.jsp");

                return;
            }

        }

        long cpf = Long.parseLong(request.getParameter("cpf"));
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        String localidade = request.getParameter("localidade");
        String dataNascimento = request.getParameter("nascimento");
        String senha = "";

        //caso a operação seja de cadastros
        if (operacao != null && !operacao.equals("editar")) {
            senha = request.getParameter("senha");
            String confirmacao = request.getParameter("confirma");

            if (!senha.equals(confirmacao)) {

                request.getSession().setAttribute("msg", "A senha e a confirmação não batem!");
                request.getSession().setAttribute("svr", "erro");

                response.sendRedirect("loginUsuario.jsp");

                return;

            }
        }

        Usuario u = new Usuario();

        u.setCpf(cpf);
        u.setDataNascimento(dataNascimento);
        u.setEmail(email);
        u.setNome(nome);
        u.setLocalidade(localidade);
        u.setTelefone(telefone);

        if (operacao != null && operacao.equals("editar")) {

            RepositorioUsuario.alterar(u);

            Usuario uAux = RepositorioUsuario.read(cpf);

            request.getSession().setAttribute("uLogado", uAux);

            request.getSession().setAttribute("msg", "Usuário alterado com sucesso!");
            request.getSession().setAttribute("svr", "sucesso");

            response.sendRedirect("perfilUsuario.jsp");

        } else {
            u.setSenha(senha);

            RepositorioUsuario.inserir(u);

            request.getSession().setAttribute("msg", "Usuário cadastrado com sucesso!");
            request.getSession().setAttribute("svr", "sucesso");

            response.sendRedirect("loginUsuario.jsp");
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
