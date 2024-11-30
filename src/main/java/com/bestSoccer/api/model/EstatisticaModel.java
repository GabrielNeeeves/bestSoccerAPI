package com.bestSoccer.api.model;


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
@Table(name = "EstatisticaJogador")
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

}
