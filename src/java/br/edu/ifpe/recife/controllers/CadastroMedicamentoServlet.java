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
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author ALUNO
 */
@WebServlet(name = "CadastroMedicamentoServlet", urlPatterns = {"/CadastroMedicamentoServlet"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024, // 1MB
        maxFileSize = 1024 * 1024 * 4,   // 4MB
        maxRequestSize = 1024 * 1024 * 4 // 4MB
        
)
public class CadastroMedicamentoServlet extends HttpServlet {

   

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
    protected void doPost(HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException {
        
        String op = request.getParameter("op");
        
        if(op.equals("file")){
            
            Part part = request.getPart("arquivo");
            
            System.out.println(part.getSize());
            byte b[] = new byte[(int)part.getSize()];
            
            part.getInputStream().read(b);
            
            response.getOutputStream().write(b);
            response.getOutputStream().flush();
            
            return;
            
        }
        
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        String nome = request.getParameter("nome");
        String principio = request.getParameter("princ");
        String dosagem = request.getParameter("dosagem");
        
        Medicamento m = new Medicamento();
        
        m.setCodigo(codigo);
        m.setNome(nome);
        m.setPrincipioAtivo(principio);
        m.setDosagem(dosagem);
        
        RepositorioMedicamento.inserir(m);
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CadastroMedicamentoServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Medicamento "+m.getNome()+" cadastrado com sucesso</h1>");
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
