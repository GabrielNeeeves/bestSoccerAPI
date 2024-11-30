package com.bestSoccer.api.model.DTO;

import java.math.BigDecimal;
import java.sql.Date;

public class JogadorDTO {
    private String nome;
    private String pernaBoa;
    private String posicao;
    private BigDecimal altura;
    private BigDecimal peso;
    private Date contrato;
    private String nacionalidade;
    private Date dataNasc;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPernaBoa() {
        return pernaBoa;
    }

    public void setPernaBoa(String pernaBoa) {
        this.pernaBoa = pernaBoa;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public BigDecimal getAltura() {
        return altura;
    }

    public void setAltura(BigDecimal altura) {
        this.altura = altura;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public Date getContrato() {
        return contrato;
    }

    public void setContrato(Date contrato) {
        this.contrato = contrato;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNas) {
        this.dataNasc = dataNas;
    }
}
