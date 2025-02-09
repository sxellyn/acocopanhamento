/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.model.repositorios;

import br.edu.ifpe.recife.model.negocio.CondicaoClinica;
import br.edu.ifpe.recife.model.negocio.Medico;
import br.edu.ifpe.recife.model.negocio.Usuario;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ALUNO
 */
public class RepositorioUsuario {

    private static List<Usuario> usuarios;

    static {
        usuarios = new ArrayList();
        
        Usuario u = new Usuario();
        u.setCpf(12313);
        u.setNome("Caio Lima Souza");
        u.setEmail("1@1");
        u.setDataNascimento("10/09/1985");
        u.setTelefone("7726176");
        u.setSenha("123");
        
        usuarios.add(u);
        
        u = new Usuario();
        u.setCpf(111);
        u.setNome("Francisco Chico City");
        u.setEmail("chicoCity@gmail.com");
        u.setDataNascimento("10/09/1985");
        u.setTelefone("7726176");
        u.setSenha("123");
        
        usuarios.add(u);
    }

    public static void inserir(Usuario usuario) {

        usuarios.add(usuario);

    }

    public static void alterar(Usuario usuario) {

        for (Usuario u : usuarios) {
            if (u.getCpf() == usuario.getCpf()) {
                u.setDataNascimento(usuario.getDataNascimento());
                u.setCondicoes(usuario.getCondicoes());
                u.setEmail(usuario.getEmail());
                u.setEvacoacoes(usuario.getEvacoacoes());
                u.setLocalidade(usuario.getLocalidade());
                u.setMedicamentos(usuario.getMedicamentos());
                u.setMedicoAcompanhante(usuario.getMedicoAcompanhante());
                u.setNome(usuario.getNome());
                u.setTelefone(usuario.getTelefone());
                return;
            }
        }

    }
    
    public static Usuario read(long cpf){
       
        for(Usuario u:usuarios){
            if(u.getCpf() == cpf){
                return u;
            }
        }
        
        return null;
    }

    public static Usuario login(String email, String senha) throws NoSuchAlgorithmException {

        for (Usuario u : usuarios) {
            if (u.getEmail().equals(email)) {
                final MessageDigest digest = MessageDigest.getInstance("MD5");
                final byte[] hashbytes = digest.digest(
                        senha.getBytes(StandardCharsets.UTF_8));
                String sha3Hex = new String(hashbytes);
                StringBuilder b = new StringBuilder();

                for (byte bAux : hashbytes) {
                    b.append(String.format("%02x", bAux));
                }
                
                if(u.getSenha().equals(b.toString())){
                    return u;
                }
                return null;
            }
        }
        return null;
    }

    public static void deletar(int codigo) {

    }
    
    //filtros
    
    public static List<Usuario> filterByCRM(String crm){
        
        List<Usuario> uPorMedico = new ArrayList<>();
        
        for(Usuario u : usuarios){
            
            for(Medico m: u.getMedicoAcompanhante()){
                if(m.getCrm().equals(crm)){
                    uPorMedico.add(u);
                    break;
                }
            }
            
        }
        
        return uPorMedico;
        
    }

    
}
