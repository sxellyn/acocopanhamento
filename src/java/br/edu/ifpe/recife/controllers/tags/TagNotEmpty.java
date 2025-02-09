/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.controllers.tags;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author ALUNO
 */
public class TagNotEmpty extends SimpleTagSupport{

    private String attr1;
    private Date data;
    
    @Override
    public void doTag() throws JspException, IOException {
        super.doTag(); //To change body of generated methods, choose Tools | Templates.
    
        StringWriter writer = new StringWriter();
        
        getJspBody().invoke(writer);
        
        getJspContext().getOut().write("<h2>"+writer.toString()+" "+this.attr1+
                " "+this.data+"</h2>");
    }

    public void setAttr1(String attr1) {
        this.attr1 = attr1;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    
    
    
}
