package com.bestSoccer.api.repository;

import com.bestSoccer.api.model.UsuarioAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface UsuarioAdminRepository extends JpaRepository<UsuarioAdmin, Long> {

    @Procedure(procedureName = "sp_admin")
    void cadAdmin(
            @Param("userid")Long userid
    );

}
