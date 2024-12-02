package com.bestSoccer.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bestSoccer.api.model.TecnicoView;
import com.bestSoccer.api.repository.TecnicoRepository;

@RestController
@RequestMapping("/tecnico")
public class TecnicoController {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @PostMapping("/cadastrar")
    public ResponseEntity<String> postTecnico(@RequestBody TecnicoView tecnicoView) {
        try {
            if (tecnicoRepository.existsByEmail(tecnicoView.getEmail())) {
                return new ResponseEntity<>("Este e-mail já está cadastrado.", HttpStatus.BAD_REQUEST);
            }
            tecnicoRepository.cadTecnico(tecnicoView.getNome(), tecnicoView.getEmail(),
            tecnicoView.getSenha(), tecnicoView.getContrato());
            return new ResponseEntity<>("Tecnico Cadastrado com Sucesso", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao cadastrar o tecnico: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/total-tecnico")
    public ResponseEntity<Long> getTotalTecnico() {
        long total = tecnicoRepository.count();
        return ResponseEntity.ok(total);
    }
}
