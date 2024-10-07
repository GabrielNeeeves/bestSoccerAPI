package com.bestSoccer.api.service;

import com.bestSoccer.api.model.UsuarioModel;
import com.bestSoccer.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    //atualizar por id
    public UsuarioModel updateUsuario(Long id, UsuarioModel nvUsuario) {
        nvUsuario.setId(id);
        return usuarioRepository.save(nvUsuario);
    }

}
