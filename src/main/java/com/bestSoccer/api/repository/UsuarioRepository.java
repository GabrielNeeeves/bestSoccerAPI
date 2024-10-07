package com.bestSoccer.api.repository;

import com.bestSoccer.api.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    //criar pela Procedure 'sp_cadUsuario'
    @Procedure(procedureName = "sp_cadUsuario")
    void cadUsuario(
            @Param("nome") String nome,
            @Param("email")String email,
            @Param("senha")String senha
    );

}
