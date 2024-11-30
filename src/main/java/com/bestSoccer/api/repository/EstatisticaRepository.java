package com.bestSoccer.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bestSoccer.api.model.EstatisticaModel;
import com.bestSoccer.api.model.EstatisticaView;

public interface EstatisticaRepository extends JpaRepository <EstatisticaModel, Long> {
    @Query("SELECT e FROM EstatisticaView e WHERE e.jogadorid = :jogadorid")
    EstatisticaView findEstatisticasByJogadorId(@Param("jogadorid") Long jogadorid);
}
