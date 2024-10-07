package com.bestSoccer.api.service;

import com.bestSoccer.api.model.UsuarioAdmin;
import com.bestSoccer.api.model.UsuarioComum;
import com.bestSoccer.api.model.UsuarioModel;
import com.bestSoccer.api.repository.UsuarioAdminRepository;
import com.bestSoccer.api.repository.UsuarioComumRepository;
import com.bestSoccer.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioAdminRepository usuarioAdminRepository;

    @Autowired
    private UsuarioComumRepository usuarioComumRepository;

    //atualizar por id
    public UsuarioModel updateUsuario(Long id, UsuarioModel nvUsuario) {
        nvUsuario.setId(id);
        return usuarioRepository.save(nvUsuario);
    }

    //atualizar usuario Admin por id
    public UsuarioAdmin updateAdmin(Long id, UsuarioAdmin nvUsuario) {
        nvUsuario.setId(id);
        return usuarioAdminRepository.save(nvUsuario);
    }

    //CREATE USUARIO ADMIN
    public UsuarioAdmin createAdmin(Long id) {
        UsuarioModel usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        UsuarioAdmin admin = new UsuarioAdmin();
        admin.setUsuario(usuario);

        return usuarioAdminRepository.save(admin);
    }

    //CREATE USUARIO COMUM
    public UsuarioComum createComum(Long id) {
        UsuarioModel usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        UsuarioComum usuarioComum = new UsuarioComum();
        usuarioComum.setUsuario(usuario);

        return usuarioComumRepository.save(usuarioComum);
    }

    //atualizar usuario Comum por id
    public UsuarioComum updateComum(Long id, UsuarioComum nvUsuario) {
        nvUsuario.setId(id);
        return usuarioComumRepository.save(nvUsuario);
    }

}
