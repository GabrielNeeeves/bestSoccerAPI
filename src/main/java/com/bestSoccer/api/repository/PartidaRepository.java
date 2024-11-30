package com.bestSoccer.api.repository;

import com.bestSoccer.api.model.PartidaModel;
<<<<<<< HEAD
import com.bestSoccer.api.model.PartidaView;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
=======
import org.springframework.data.jpa.repository.JpaRepository;
>>>>>>> 8d1a811845ebbdb5c87c677cfe98c927da441271
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
<<<<<<< HEAD
import java.time.LocalTime;
import java.util.List;

public interface PartidaRepository extends JpaRepository<PartidaModel, Long> {

=======
import java.sql.Time;
import java.time.LocalTime;

public interface PartidaRepository extends JpaRepository<PartidaModel, Long> {

    //criar pela procedure 'sp_cadPartida'
>>>>>>> 8d1a811845ebbdb5c87c677cfe98c927da441271
    @Procedure(procedureName = "sp_cadPartida")
    void cadPartida(
            @Param("data")Date data,
            @Param("hora") LocalTime hora,
<<<<<<< HEAD
            @Param("timeAdversario")String timeAdversario,
            @Param("campeonato")String campeonato,
            @Param("foto")String foto
            );

    @Query("SELECT p FROM PartidaView p")
    List<PartidaView> findAllPartida();
=======
            @Param("timeadv")String timeadv,
            @Param("local")String local
            );

>>>>>>> 8d1a811845ebbdb5c87c677cfe98c927da441271
}
