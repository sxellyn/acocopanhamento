/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.controllers;

import br.edu.ifpe.recife.model.negocio.CondicaoClinica;
import br.edu.ifpe.recife.model.negocio.Medico;
import br.edu.ifpe.recife.model.negocio.Usuario;
import br.edu.ifpe.recife.model.repositorios.RepositorioCondicaoClinica;
import br.edu.ifpe.recife.model.repositorios.RepositorioMedico;
import br.edu.ifpe.recife.model.repositorios.RepositorioUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kaize
 */
@WebServlet(name = "MedicoController", urlPatterns = {"/Medico"})
public class MedicoController extends HttpServlet {

    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        
        String op = request.getParameter("op");
        
        switch(op){
            case "logout":
                request.getSession().invalidate();
                response.sendRedirect("index.html");
                break;
            
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
        
        String op = request.getParameter("op");
        
        switch(op){
            case "login":
            {
                String crm = request.getParameter("crm");
                String senha = request.getParameter("senha");
                Medico m = RepositorioMedico.realizarLogin(crm, senha);
                if(m == null){
                    request.getSession().setAttribute("msg", "Erro ao logar!");
                    response.sendRedirect("loginMedico.jsp");
                }else{
                    request.getSession().setAttribute("mLogado", m);
                    response.sendRedirect("indexMedico.jsp");
                }
                break;
            }
                
            case "editar":
            {
                String crm = request.getParameter("crm");
                String nome = request.getParameter("nome");
                String especialidade = request.getParameter("especialidade");
                String contato = request.getParameter("contato");
                
                Medico m = new Medico();
                m.setContato(contato);
                m.setCrm(crm);
                m.setEspecialidade(especialidade);
                m.setNome(nome);
                
                RepositorioMedico.alterar(m);
                
                request.getSession().setAttribute("msg", "Dados do médico alterados com sucesso!");
                request.getSession().setAttribute("svr", "sucesso");
                
                response.sendRedirect("perfilMedico.jsp");
                
                break;
                
            }
            
            case "senha":
            {
                String atual = request.getParameter("atual");
                String nova = request.getParameter("nova");
                String confirma = request.getParameter("confirma");
                
                boolean result = RepositorioMedico.alterarSenha(
                        ((Medico)request.getSession().getAttribute("mLogado")).getCrm(), atual, nova, confirma);
                
                if(result){
                    request.getSession().setAttribute("msg", "senha alterada com sucesso!");
                    request.getSession().setAttribute("svr", "sucesso");
                }
                else{
                    request.getSession().setAttribute("msg", "Problema ao alterar a senha!");
                }
                
                response.sendRedirect("perfilMedico.jsp");
                
                break;
                
            }
            
            case "acompanhar":
                {
                    Medico medico = (Medico)request.getSession().getAttribute("mLogado");
                    String cpf = request.getParameter("cpf");
                    Usuario usuario = RepositorioUsuario.read(Long.parseLong(cpf));
                    
                    usuario.getMedicoAcompanhante().add(medico);
                    
                    RepositorioUsuario.alterar(usuario);
                    
                    request.getSession().setAttribute("msg", "Parabéns, você está acompanhando o paciente "+usuario.getNome()+"!");
                    request.getSession().setAttribute("svr", "sucesso");
                
                    response.sendRedirect("indexMedico.jsp");
                    
                    break;
                }
                
            case "inserirCondicao":
                {
                    String cpf = request.getParameter("cpf");
                    int condicao = Integer.parseInt(request.getParameter("condicao"));
                    
                    Usuario paciente = RepositorioUsuario.read(Long.parseLong(cpf));
                    CondicaoClinica  condicaoC = RepositorioCondicaoClinica.ler(condicao);
                    
                    paciente.getCondicoes().add(condicaoC);
                    
                    RepositorioUsuario.alterar(paciente);
                    
                    request.getSession().setAttribute("msg", "Condição clínica inserida no paciente "+paciente.getNome()+
                            " com sucesso!");
                    request.getSession().setAttribute("svr", "sucesso");
                
                    response.sendRedirect("indexMedico.jsp");
                    
                    break;
                    
                }
                
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
