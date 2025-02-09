/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.model.negocio;

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
public class Usuario {

    private long cpf;
    private String nome;
    private String email;
    private String telefone;
    private String localidade;
    private String dataNascimento;
    private String senha;

    private List<Medico> medicoAcompanhante;
    private List<Medicamento> medicamentos;
    private List<CondicaoClinica> condicoes;
    private List<Evacuada> evacoacoes;
    
    public Usuario(){
        this.medicamentos = new ArrayList<>();
        this.medicoAcompanhante = new ArrayList<>();
        this.condicoes = new ArrayList<>();
        this.evacoacoes = new ArrayList<>();
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Medico> getMedicoAcompanhante() {
        return medicoAcompanhante;
    }

    public void setMedicoAcompanhante(List<Medico> medicoAcompanhante) {
        this.medicoAcompanhante = medicoAcompanhante;
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public List<CondicaoClinica> getCondicoes() {
        return condicoes;
    }

    public void setCondicoes(List<CondicaoClinica> condicoes) {
        this.condicoes = condicoes;
    }

    public List<Evacuada> getEvacoacoes() {
        return evacoacoes;
    }

    public void setEvacoacoes(List<Evacuada> Evacoacoes) {
        this.evacoacoes = Evacoacoes;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        final MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");

            final byte[] hashbytes = digest.digest(
                    senha.getBytes(StandardCharsets.UTF_8));
            String sha3Hex = new String(hashbytes);
            StringBuilder b = new StringBuilder();

            for (byte bAux : hashbytes) {
                b.append(String.format("%02x", bAux));
            }

            this.senha = b.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
