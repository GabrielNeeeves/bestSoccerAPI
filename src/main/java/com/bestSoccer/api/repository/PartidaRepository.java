package com.bestSoccer.api.repository;

import com.bestSoccer.api.model.PartidaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

public interface PartidaRepository extends JpaRepository<PartidaModel, Long> {

    //criar pela procedure 'sp_cadPartida'
    @Procedure(procedureName = "sp_cadPartida")
    void cadPartida(
            @Param("data")Date data,
            @Param("hora") LocalTime hora,
            @Param("timeadv")String timeadv,
            @Param("local")String local
            );

}
