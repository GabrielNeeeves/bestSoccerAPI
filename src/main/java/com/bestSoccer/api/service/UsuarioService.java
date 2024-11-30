package com.bestSoccer.api.service;

<<<<<<< HEAD
import com.bestSoccer.api.model.UsuarioView;
import com.bestSoccer.api.repository.UsuarioRepository;


=======
import com.bestSoccer.api.model.UsuarioAdmin;
import com.bestSoccer.api.model.UsuarioComum;
import com.bestSoccer.api.model.UsuarioModel;
import com.bestSoccer.api.repository.UsuarioAdminRepository;
import com.bestSoccer.api.repository.UsuarioComumRepository;
import com.bestSoccer.api.repository.UsuarioRepository;
>>>>>>> 8d1a811845ebbdb5c87c677cfe98c927da441271
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

<<<<<<< HEAD
    public UsuarioView login(String email, String senha) {
        return usuarioRepository.findByEmailAndSenha(email, senha);
    }

    public boolean verificarAdmin(Long usuarioId) {
        return usuarioRepository.isAdmin(usuarioId);
    }

    public boolean verificarTecnico(Long usuarioId) {
        return usuarioRepository.isTecnico(usuarioId);
    }
}
=======
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
    public void createComum(Long id) {
        UsuarioModel usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        usuarioComumRepository.cadComum(id);
    }

    //atualizar usuario Comum por id
    public UsuarioComum updateComum(Long id, UsuarioComum nvUsuario) {
        nvUsuario.setId(id);
        return usuarioComumRepository.save(nvUsuario);
    }

}
>>>>>>> 8d1a811845ebbdb5c87c677cfe98c927da441271
