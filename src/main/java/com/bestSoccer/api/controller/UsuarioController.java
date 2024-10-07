package com.bestSoccer.api.controller;

import com.bestSoccer.api.model.DTO.UsuarioDTO;
import com.bestSoccer.api.model.UsuarioModel;
import com.bestSoccer.api.repository.UsuarioRepository;
import com.bestSoccer.api.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

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

}
