/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.model.negocio;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ALUNO
 */
public class Evacuada {
    
    private int codigo;
    
    private long data;
    private String aspecto;
    private String cor;
    private String intensidadeDor;
    private boolean sanguePresente;
    private String intensidadeCheiro;
    private String volume;
    private byte[] imagem;
    
    private String observacoes;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public long getData() {
        return data;
    }

    public void setData(long data) {
        this.data = data;
    }
    
    public String getDataFormatada(){
        return new SimpleDateFormat("dd:MM:yyyy - hh:mm").format(new Date(this.data));
    }

    public String getAspecto() {
        return aspecto;
    }

    public void setAspecto(String aspecto) {
        this.aspecto = aspecto;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getIntensidadeDor() {
        return intensidadeDor;
    }

    public void setIntensidadeDor(String intensidadeDor) {
        this.intensidadeDor = intensidadeDor;
    }

    public boolean isSanguePresente() {
        return sanguePresente;
    }

    public void setSanguePresente(boolean sanguePresente) {
        this.sanguePresente = sanguePresente;
    }

    public String getIntensidadeCheiro() {
        return intensidadeCheiro;
    }

    public void setIntensidadeCheiro(String intensidadeCheiro) {
        this.intensidadeCheiro = intensidadeCheiro;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    
    
    
    
}
