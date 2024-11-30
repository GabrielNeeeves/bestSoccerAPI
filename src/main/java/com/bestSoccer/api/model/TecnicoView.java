package com.bestSoccer.api.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "v_tecnico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TecnicoView extends UsuarioView {

    @Id
    private Long id;
    private LocalDate contrato;
}
