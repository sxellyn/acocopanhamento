/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.controllers.tags;

import br.edu.ifpe.recife.model.negocio.CondicaoClinica;
import br.edu.ifpe.recife.model.repositorios.RepositorioCondicaoClinica;
import java.io.IOException;
import java.util.List;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author ALUNO
 */
public class CarregaCondicao extends SimpleTagSupport{

    @Override
    public void doTag() throws JspException, IOException {
        super.doTag(); //To change body of generated methods, choose Tools | Templates.
    
        List<CondicaoClinica> condicoes = RepositorioCondicaoClinica.lerTudo();
    
        getJspContext().setAttribute("condicoes", condicoes
                , PageContext.PAGE_SCOPE);
    }
    
}
