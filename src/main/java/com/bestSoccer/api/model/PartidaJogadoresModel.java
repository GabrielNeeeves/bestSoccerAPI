package com.bestSoccer.api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PartidaJogadores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(PartidaJogadorId.class)
public class PartidaJogadoresModel {

    @Id
    @Column(nullable = false)
    private Long partidaId;

    @Id
    @Column(nullable = false)
    private Long jogadorId;

    @Column(nullable = false)
    private int gols;

    @ManyToOne
    @JoinColumn(name = "partidaId", insertable = false, updatable = false)
    private PartidaModel partida;

    @ManyToOne
    @JoinColumn(name = "jogadorId", insertable = false, updatable = false)
    private JogadorModel jogador;
}
