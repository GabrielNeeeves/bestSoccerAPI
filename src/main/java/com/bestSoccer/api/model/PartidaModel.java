package com.bestSoccer.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Partida")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PartidaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false)
    private LocalTime hora;

    @Column(name = "timeadversario", length = 100, nullable = false)
    private String timeAdversario;

    @Column(nullable = false)
<<<<<<< HEAD
    private String campeonato;

    @Column(nullable = false)
    private String foto;

=======
    private String local;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getTimeAdversario() {
        return timeAdversario;
    }

    public void setTimeAdversario(String timeAdversario) {
        this.timeAdversario = timeAdversario;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
>>>>>>> 8d1a811845ebbdb5c87c677cfe98c927da441271
}
