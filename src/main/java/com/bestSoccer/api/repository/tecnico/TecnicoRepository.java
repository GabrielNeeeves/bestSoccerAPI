package com.bestSoccer.api.repository.tecnico;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.bestSoccer.api.model.tecnico.TecnicoModel;

public interface TecnicoRepository extends JpaRepository<TecnicoModel, Long> {
    
    
    @Procedure(procedureName = "sp_cadTecnico")
    void cadTecnico(
            @Param("nome") String nome,
            @Param("email") String email,
            @Param("senha") String senha,
            @Param("contrato") LocalDate contrato);

    boolean existsByEmail(String email);

}
