package com.bestSoccer.api.repository;

import com.bestSoccer.api.model.UsuarioComum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioComumRepository extends JpaRepository<UsuarioComum, Long> {

    @Procedure(procedureName = "sp_comum")
    void cadComum(
            @Param("usuarioid")Long usuarioid
    );

}
