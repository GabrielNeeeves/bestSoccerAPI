package com.bestSoccer.api.repository;


import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.bestSoccer.api.model.EstatisticaModel;
import com.bestSoccer.api.model.EstatisticaView;

public interface EstatisticaRepository extends JpaRepository <EstatisticaModel, Long> {
    // @Procedure(procedureName = "sp_cadestatisticajogador")
    // void cadJogador(
    //         @Param("nome") String nome,
    //         @Param("pernadominante") String pernadominante,
    //         @Param("posicao") String posicao,
    //         @Param("altura") BigDecimal altura,
    //         @Param("peso") BigDecimal peso,
    //         @Param("contrato") LocalDate contrato,
    //         @Param("nacionalidade") String nacionalidade,
    //         @Param("datanascimento") LocalDate datanascimento,
    //         @Param("foto") String foto);

    @Query("SELECT e FROM EstatisticaView e WHERE e.jogadorid = :jogadorid")
    EstatisticaView findEstatisticasByJogadorId(@Param("jogadorid") Long jogadorid);
}
