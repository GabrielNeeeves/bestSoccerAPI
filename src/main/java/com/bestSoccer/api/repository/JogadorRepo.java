package com.bestSoccer.api.repository;

import com.bestSoccer.api.model.JogadorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.sql.Date;

public interface JogadorRepo extends JpaRepository<JogadorModel, Long> {

    //criar Jogador pela Procedure
    @Procedure(procedureName = "sp_cadjogador")
    void cadJogador(
            @Param("nome") String nome,
            @Param("pernaboa") String pernaBoa,
            @Param("posicao") String posicao,
            @Param("altura") BigDecimal altura,
            @Param("peso") BigDecimal peso,
            @Param("contr") Date contrato,
            @Param("nac") String nacionalidade,
            @Param("datanasc") Date dataNascimento
    );


}
