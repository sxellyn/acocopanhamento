/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.recife.model.negocio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ALUNO
 */
public class CondicaoClinica {
    
    private int codigo;
    
    private String nome;
    //pode ser doença, cirurgia, aciendente, etc.
    private String tipo;
    private long dataInicio;
    private String observacao;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public long getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(long dataInicio) {
        this.dataInicio = dataInicio;
    }
    
    public void setDataInicioString(String data) throws ParseException{
        this.dataInicio = new SimpleDateFormat("dd/MM/yyyy").parse(data).getTime();
    }
    
    public String getDataInicioString(){
        return new SimpleDateFormat("dd/MM/yyyy").format(new Date(this.dataInicio));
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    
}
