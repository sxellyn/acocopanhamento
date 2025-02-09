/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.model.repositorios;

import br.edu.ifpe.recife.model.negocio.CondicaoClinica;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ALUNO
 */
public class RepositorioCondicaoClinica {
    
    private static List<CondicaoClinica> condicoes;
    
    static{
        try {
            condicoes = new ArrayList();
            
            CondicaoClinica c = new CondicaoClinica();
            c.setCodigo(4);
            c.setNome("Unha Encravada");
            c.setDataInicioString("12/11/2024");
            c.setTipo("incomodo");
            c.setObservacao("Impede que a pessoa ande");
            
            condicoes.add(c);
            
            c = new CondicaoClinica();
            c.setCodigo(5);
            c.setNome("Ureia de Abano");
            c.setDataInicioString("19/11/1920");
            c.setTipo("estético");
            c.setObservacao("Incomoda a imagem!");
            
            condicoes.add(c);
            
        } catch (ParseException ex) {
            Logger.getLogger(RepositorioCondicaoClinica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void inserir(CondicaoClinica condicao){
        
        condicoes.add(condicao);
        
    }
    
    public static void alterar(CondicaoClinica condicao){
        
        for(CondicaoClinica c: condicoes){
            if(c.getCodigo() == condicao.getCodigo()){
                c.setDataInicio(condicao.getDataInicio());
                c.setNome(condicao.getNome());
                c.setObservacao(condicao.getObservacao());
                c.setTipo(condicao.getTipo());
                
                return;
            }
        }
        
    }
    
    public static CondicaoClinica ler(int codigo){
        for(CondicaoClinica c: condicoes){
            if(c.getCodigo() == codigo){
                return c;
            }
        }
        return null;
    }
    
    public static void deletar(int codigo){
        
        for(int i = 0; i < condicoes.size(); i++){
            CondicaoClinica c = condicoes.get(i);
            
            if(c.getCodigo() == codigo){
                condicoes.remove(i);
                return;
            }
            
            
        }
        
    }
    
    public static List<CondicaoClinica> lerTudo(){
        return condicoes;
    }
    
}
