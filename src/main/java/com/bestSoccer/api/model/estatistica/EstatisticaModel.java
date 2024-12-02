package com.bestSoccer.api.model.estatistica;

import com.bestSoccer.api.model.jogador.JogadorModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;


import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "estatisticasjogador")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstatisticaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id", nullable = false) 
    private JogadorModel jogador;
    private int jogosdisputados;
    private int golsmarcados;
    private int assistencias;
    private int finalizacoes;
    private int passes;
    private int desarmes;
    private int faltascometidas;
    private int cartoesamarelos;
    private int cartoesvermelhos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public JogadorModel getJogador() {
        return jogador;
    }

    public void setJogador(JogadorModel jogador) {
        this.jogador = jogador;
    }

    public int getJogosdisputados() {
        return jogosdisputados;
    }

    public void setJogosdisputados(int jogosdisputados) {
        this.jogosdisputados = jogosdisputados;
    }

    public int getGolsmarcados() {
        return golsmarcados;
    }

    public void setGolsmarcados(int golsmarcados) {
        this.golsmarcados = golsmarcados;
    }

    public int getAssistencias() {
        return assistencias;
    }

    public void setAssistencias(int assistencias) {
        this.assistencias = assistencias;
    }

    public int getFinalizacoes() {
        return finalizacoes;
    }

    public void setFinalizacoes(int finalizacoes) {
        this.finalizacoes = finalizacoes;
    }

    public int getPasses() {
        return passes;
    }

    public void setPasses(int passes) {
        this.passes = passes;
    }

    public int getDesarmes() {
        return desarmes;
    }

    public void setDesarmes(int desarmes) {
        this.desarmes = desarmes;
    }

    public int getFaltascometidas() {
        return faltascometidas;
    }

    public void setFaltascometidas(int faltascometidas) {
        this.faltascometidas = faltascometidas;
    }

    public int getCartoesamarelos() {
        return cartoesamarelos;
    }

    public void setCartoesamarelos(int cartoesamarelos) {
        this.cartoesamarelos = cartoesamarelos;
    }

    public int getCartoesvermelhos() {
        return cartoesvermelhos;
    }

    public void setCartoesvermelhos(int cartoesvermelhos) {
        this.cartoesvermelhos = cartoesvermelhos;
    }
}