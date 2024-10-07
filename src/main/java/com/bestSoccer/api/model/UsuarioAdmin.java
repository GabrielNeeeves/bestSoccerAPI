package com.bestSoccer.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "UsuarioAdmin")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsuarioAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuarioid")
    private Long id;

    @OneToOne
    @JoinColumn(name = "usuarioid", referencedColumnName = "id", insertable = false, updatable = false)
    private UsuarioModel usuario;

}
