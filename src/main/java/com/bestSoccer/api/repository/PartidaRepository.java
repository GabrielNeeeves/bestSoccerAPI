package com.bestSoccer.api.repository;

import com.bestSoccer.api.model.PartidaModel;
import com.bestSoccer.api.model.PartidaView;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.time.LocalTime;
import java.util.List;

public interface PartidaRepository extends JpaRepository<PartidaModel, Long> {

    @Procedure(procedureName = "sp_cadPartida")
    void cadPartida(
            @Param("data")Date data,
            @Param("hora") LocalTime hora,
            @Param("timeAdversario")String timeAdversario,
            @Param("campeonato")String campeonato,
            @Param("foto")String foto
            );

    @Query("SELECT p FROM PartidaView p")
    List<PartidaView> findAllPartida();
}
