package com.bestSoccer.api.repository;

import com.bestSoccer.api.model.UsuarioModel;
<<<<<<< HEAD
import com.bestSoccer.api.model.UsuarioView;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;


public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    @Procedure(procedureName = "sp_cadUsuario")
    void cadUsuario(
            @Param("nome") String nome,
            @Param("email") String email,
            @Param("senha") String senha
    );

    boolean existsByEmail(String email);

    @Query("SELECT u FROM UsuarioView u WHERE u.email = :email AND u.senha = :senha")
    UsuarioView findByEmailAndSenha(@Param("email") String email, @Param("senha") String senha);

    @Query(value = "SELECT CASE WHEN COUNT(1) > 0 THEN true ELSE false END FROM v_admin WHERE usuarioId = :usuarioId", nativeQuery = true)
    boolean isAdmin(@Param("usuarioId") Long usuarioId);

    @Query(value = "SELECT CASE WHEN COUNT(1) > 0 THEN true ELSE false END FROM v_tecnico WHERE usuarioId = :usuarioId", nativeQuery = true)
    boolean isTecnico(@Param("usuarioId") Long usuarioId);
=======
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

>>>>>>> 8d1a811845ebbdb5c87c677cfe98c927da441271
}
