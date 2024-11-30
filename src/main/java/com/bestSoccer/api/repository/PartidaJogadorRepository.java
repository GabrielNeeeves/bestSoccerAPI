package com.bestSoccer.api.repository;


import com.bestSoccer.api.model.PartidaJogadorId;
import com.bestSoccer.api.model.PartidaJogadorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;

public interface PartidaJogadorRepository extends JpaRepository<PartidaJogadorModel, PartidaJogadorId> {

    @Procedure(procedureName = "sp_cadPartidaJogadores")
    void cadPartidaJogador(
            @Param("partidaid")Integer partidaid,
            @Param("jogadorid")Integer jogadorid,
            @Param("gols")Integer gols
            );

}
