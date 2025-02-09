/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.model.repositorios;

import br.edu.ifpe.recife.model.negocio.Medicamento;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ALUNO
 */
public class RepositorioMedicamento {
    
    private static List<Medicamento> medicamentos;
    
    static{
        
        medicamentos = new ArrayList<>();
        
        Medicamento m = new Medicamento();
        m.setCodigo(1);
        m.setNome("Tylenol");
        m.setDosagem("mg");
        m.setPrincipioAtivo("Paracetamol");
        
        medicamentos.add(m);
        
        m = new Medicamento();
        m.setCodigo(2);
        m.setNome("Dorflex");
        m.setDosagem("mg");
        m.setPrincipioAtivo("Dipirona");
        
        medicamentos.add(m);
        
    }
    
    public static void inserir(Medicamento m){
        medicamentos.add(m);
    }
    
    public static void alterar(Medicamento m){
        
        for(Medicamento mAux: medicamentos){
            
            if(mAux.getCodigo() == m.getCodigo()){
                mAux.setDosagem(m.getDosagem());
                mAux.setNome(m.getNome());
                mAux.setPrincipioAtivo(m.getPrincipioAtivo());
                
                return;
            }
            
        }
        
    }
    
    public static Medicamento ler(int codigo){
        
        for(Medicamento m: medicamentos){
            if(m.getCodigo() ==  codigo){
                return m;
            }
        }
        return null;
    }
    
    public static void delete(int codigo){
        for(int i = 0; i < medicamentos.size();i++){
            Medicamento m = medicamentos.get(i);
            if(m.getCodigo() == codigo){
                medicamentos.remove(m);
                return;
            }
        }
    }
    
    public static List<Medicamento> lerTudo(){
        return medicamentos;
    }
    
}
