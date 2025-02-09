/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.controllers.tags;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author ALUNO
 */
public class TagViagi extends SimpleTagSupport{

    private Class classe;
    private String submitURL;
    
    @Override
    public void doTag() throws JspException, IOException {
        super.doTag(); //To change body of generated methods, choose Tools | Templates.
        
        String form = "<form method='post' action='"+this.submitURL+"'>";
        
        for(Field field : classe.getDeclaredFields()){
            
            form+=field.getName()+": <input type='text' name='"+field.getName()+"'/></br>";
            
        }
        
        form += "<input type='submit' value='cadastrar'/></form>";
        
        getJspContext().getOut().write(form);
    }

    public void setClasse(Class classe) {
        this.classe = classe;
    }

    public void setSubmitURL(String submitURL) {
        this.submitURL = submitURL;
    }
    
    
    
}
