package com.bestSoccer.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "v_estatisticas_jogador ")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class EstatisticaView {
    @Id
    private Long id;

    private Long jogadorid;
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
