package com.bestSoccer.api.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "v_partida")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PartidaView {

    @Id
    private Long id;

    private LocalDate data;
    private LocalTime hora;
    private String timeadversario;
    private String campeonato;
    private String foto;
}
