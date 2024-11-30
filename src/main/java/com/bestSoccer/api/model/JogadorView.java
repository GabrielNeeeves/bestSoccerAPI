package com.bestSoccer.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "v_jogador")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JogadorView {

    @Id
    private Long id;
    private String nome;
    private String pernadominante;
    private String posicao;
    private BigDecimal altura;
    private BigDecimal peso;
    private LocalDate contrato;
    private String nacionalidade;
    private LocalDate datanascimento;
    private String foto;

}
