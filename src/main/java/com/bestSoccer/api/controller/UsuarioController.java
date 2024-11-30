package com.bestSoccer.api.controller;

<<<<<<< HEAD
import com.bestSoccer.api.model.UsuarioView;
import com.bestSoccer.api.repository.UsuarioRepository;
import com.bestSoccer.api.service.UsuarioService;

=======
import com.bestSoccer.api.model.DTO.UsuarioDTO;
import com.bestSoccer.api.model.UsuarioAdmin;
import com.bestSoccer.api.model.UsuarioComum;
import com.bestSoccer.api.model.UsuarioModel;
import com.bestSoccer.api.repository.UsuarioAdminRepository;
import com.bestSoccer.api.repository.UsuarioComumRepository;
import com.bestSoccer.api.repository.UsuarioRepository;
import com.bestSoccer.api.service.UsuarioService;
>>>>>>> 8d1a811845ebbdb5c87c677cfe98c927da441271
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD
@RestController
@RequestMapping("/usuario")
=======
import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
>>>>>>> 8d1a811845ebbdb5c87c677cfe98c927da441271
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
<<<<<<< HEAD
    private UsuarioService usuarioService;

    @PostMapping("/cadastrar")
    public ResponseEntity<String> postUsuario(@RequestBody UsuarioView usuarioView) {
        try {
            if (usuarioRepository.existsByEmail(usuarioView.getEmail())) {
                return new ResponseEntity<>("Este e-mail já está cadastrado.", HttpStatus.BAD_REQUEST);
            }
            usuarioRepository.cadUsuario(usuarioView.getNome(), usuarioView.getEmail(),
            usuarioView.getSenha());
            return new ResponseEntity<>("Usuário Cadastrado com Sucesso", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao cadastrar o usuário: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuarioView usuarioView) {
        try {
            UsuarioView usuario = usuarioService.login(usuarioView.getEmail(), usuarioView.getSenha());

            if (usuario == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
            }

            Long usuarioId = usuario.getId();

            if (usuarioService.verificarAdmin(usuarioId)) {
                return ResponseEntity.ok(new LoginResponse("Login realizado com sucesso", usuario.getNome(), "admin"));
            }
            if (usuarioService.verificarTecnico(usuarioId)) {
                return ResponseEntity
                        .ok(new LoginResponse("Login realizado com sucesso", usuario.getNome(), "tecnico"));
            }
            return ResponseEntity.ok(new LoginResponse("Login realizado com sucesso", usuario.getNome(), "comum"));

        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao realizar login: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static class LoginResponse {
        private String mensagem;
        private String nomeUsuario;
        private String tipoUsuario;

        public LoginResponse(String mensagem, String nomeUsuario, String tipoUsuario) {
            this.mensagem = mensagem;
            this.nomeUsuario = nomeUsuario;
            this.tipoUsuario = tipoUsuario;
        }

        public String getMensagem() {
            return mensagem;
        }

        public String getNomeUsuario() {
            return nomeUsuario;
        }

        public String getTipoUsuario() {
            return tipoUsuario;
=======
    private UsuarioAdminRepository usuarioAdminRepository;

    @Autowired
    private UsuarioComumRepository usuarioComumRepository;

    @Autowired
    private UsuarioService usuarioService;

    //GET
    @GetMapping
    public ResponseEntity<List<UsuarioModel>> getUsuarios() {
        List<UsuarioModel> lista = usuarioRepository.findAll();
        return ResponseEntity.ok(lista);
    }

    //POST
    @PostMapping
    public ResponseEntity<String> postUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        try {
            usuarioRepository.cadUsuario(usuarioDTO.getNome(), usuarioDTO.getEmail(), usuarioDTO.getSenha());
            return new ResponseEntity<>("Usuario cadastrado", HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>("Falha ao cadastrar usuario" +e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

    //DELETE BY ID
    @DeleteMapping("/{id}")
    public void delUsuario(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
    }

    //UPDATE BY ID
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioModel> updateUsuario(@PathVariable Long id, @RequestBody UsuarioModel nvUsuario) {
        try {
            UsuarioModel novoUsuario = usuarioService.updateUsuario(id, nvUsuario);
            return ResponseEntity.ok(novoUsuario);
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    //==============================================================================================
    // Usuarios ADMINs
    //==============================================================================================

    //GET ADMINS
    @GetMapping("/admin")
    public ResponseEntity<List<UsuarioAdmin>> getAdmin() {
        List<UsuarioAdmin> lista = usuarioAdminRepository.findAll();
        return ResponseEntity.ok(lista);
    }

    //POST ADMIN
    @PostMapping("/admin/{id}")
    public ResponseEntity<UsuarioAdmin> postAdmin(@PathVariable Long id) {

        UsuarioAdmin userAdmin = usuarioService.createAdmin(id);
        return ResponseEntity.ok(userAdmin);
    }

    //==============================================================================================
    // Usuarios Comums
    //==============================================================================================

    //GET
    @GetMapping("/comum")
    public ResponseEntity<List<UsuarioComum>> getComum() {
        List<UsuarioComum> lista = usuarioComumRepository.findAll();
        return ResponseEntity.ok(lista);
    }

    //POST COMUM
    @PostMapping("/comum/{id}")
    public ResponseEntity<String> postComum(@PathVariable Long id) {
        try {
            usuarioService.createComum(id);
            return new ResponseEntity<>("Usuário Comum cadastrado com sucesso", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao cadastrar usuário comum: " + e.getMessage(), HttpStatus.BAD_REQUEST);

>>>>>>> 8d1a811845ebbdb5c87c677cfe98c927da441271
        }
    }
}
