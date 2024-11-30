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
    private Integer jogosdisputados;
    private Integer golsmarcados;
    private Integer assistencias;
    private Integer finalizacoes;
    private Integer passes;
    private Integer desarmes;
    private Integer faltascometidas;
    private Integer cartoesamarelos;
    private Integer cartoesvermelhos;

}
