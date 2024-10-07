package com.bestSoccer.api.controller;

import com.bestSoccer.api.model.DTO.UsuarioDTO;
import com.bestSoccer.api.model.UsuarioAdmin;
import com.bestSoccer.api.model.UsuarioComum;
import com.bestSoccer.api.model.UsuarioModel;
import com.bestSoccer.api.repository.UsuarioAdminRepository;
import com.bestSoccer.api.repository.UsuarioComumRepository;
import com.bestSoccer.api.repository.UsuarioRepository;
import com.bestSoccer.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
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

        }
    }
}
