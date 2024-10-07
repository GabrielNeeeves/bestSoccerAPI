package com.bestSoccer.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(
        name = "Jogador",
        uniqueConstraints = @UniqueConstraint(columnNames = "id") // ----> PODE DAR ERRO <----
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JogadorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 10)
    private String pernaBoa;

    @Column(nullable = false, length = 50)
    private String posicao;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal altura;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal  peso;

    @Column(nullable = false)
    private LocalDate contrato;

    @Column(nullable = false, length = 50)
    private String nacionalidade;

    @Column(nullable = false)
    private LocalDate dataNascimento;

}
