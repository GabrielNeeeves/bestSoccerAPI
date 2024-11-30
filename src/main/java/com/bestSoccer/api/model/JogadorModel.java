package com.bestSoccer.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
<<<<<<< HEAD

@Entity
@Table(name = "Jogador")
=======
import java.util.Date;

@Entity
@Table(name = "jogador")
>>>>>>> 8d1a811845ebbdb5c87c677cfe98c927da441271
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

<<<<<<< HEAD
    @Column(name = "pernadominante", nullable = false, length = 10)
    private String pernaDominante;
=======
    @Column(name = "pernaboa", nullable = false, length = 10)
    private String pernaBoa;
>>>>>>> 8d1a811845ebbdb5c87c677cfe98c927da441271

    @Column(nullable = false, length = 50)
    private String posicao;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal altura;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal peso;

    @Column(nullable = false)
    private LocalDate contrato;

    @Column(nullable = false, length = 50)
    private String nacionalidade;

    @Column(name = "datanascimento", nullable = false)
    private LocalDate dataNascimento;

<<<<<<< HEAD
    @Column
    private String foto;

    @OneToOne(mappedBy = "jogador", cascade = CascadeType.ALL)
    private EstatisticaModel  estatisticas;
=======
    public JogadorModel(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public LocalDate getContrato() {
        return contrato;
    }

    public void setContrato(LocalDate contrato) {
        this.contrato = contrato;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
>>>>>>> 8d1a811845ebbdb5c87c677cfe98c927da441271
}
