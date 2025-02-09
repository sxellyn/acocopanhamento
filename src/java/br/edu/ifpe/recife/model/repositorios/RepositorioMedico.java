/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.model.repositorios;

import br.edu.ifpe.recife.model.negocio.CondicaoClinica;
import br.edu.ifpe.recife.model.negocio.Medico;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ALUNO
 */
public class RepositorioMedico {
    
    private static List<Medico> medicos;
    
    static{
        medicos = new ArrayList();
        
        Medico m = new Medico();
        m.setCrm("123");
        m.setContato("wqweqweqe");
        m.setEspecialidade("Gastro");
        m.setNome("dr. Hans Shucrutte");
        m.setSenha("123");
        
        medicos.add(m);
        
        m = new Medico();
        m.setCrm("111");
        m.setContato("wqweqweqe");
        m.setEspecialidade("nutrologo");
        m.setNome("dr. Chuleta Braza");
        m.setSenha("123");
        
        medicos.add(m);
    }
    
    public static void inserir(Medico medico){
        medicos.add(medico);
    }
    
    public static void alterar(Medico medico){
        
        for(Medico mAux: medicos){
            if(mAux.getCrm().equals(medico.getCrm())){
                mAux.setContato(medico.getContato());
                mAux.setEspecialidade(medico.getEspecialidade());
                mAux.setNome(medico.getNome());
                return;
            }
        }
        
    }
    
    public static boolean alterarSenha(String crm, String atual, String nova, String confirma){
        
       if(!nova.equals(confirma)){
           return false;
       }
        
       for(Medico m: medicos){
           if(m.getCrm().equals(crm)){
               
               if(m.getSenha().equals(atual)){
                   m.setSenha(nova);
                   return true;
               }
           }
       }
        return false;
    }
    
    public static Medico ler(String crm){
        
        for(Medico mAux: medicos){
            if(mAux.getCrm().equals(crm)){
                return mAux;
            }
        }
        
        return null;
    }
    
    public static void deletar(int codigo){
        
    }
    
    public static Medico realizarLogin(String crm, String senha){
        
        for(Medico mAux: medicos){
            if(mAux.getCrm().equals(crm) && mAux.getSenha().equals(senha)){
                return mAux;
            }
        }
        
        return null;
        
    }
    
    public static List<Medico> lerTudo(){
        return medicos;
    }
    
}
