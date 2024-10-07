package com.bestSoccer.api.controller;

import com.bestSoccer.api.model.DTO.JogadorDTO;
import com.bestSoccer.api.model.JogadorModel;
import com.bestSoccer.api.repository.JogadorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/jogadores")
public class JogadorController {

    @Autowired
    private JogadorRepo jogadorRepo;

    //GET
    @GetMapping
    public ResponseEntity<List<JogadorModel>> getJogador() {
        return ResponseEntity.ok(jogadorRepo.findAll());
    }

    //POST
    @PostMapping
    public ResponseEntity<String> postJogador(@RequestBody JogadorDTO jogDTO) {
        try {
            jogadorRepo.cadJogador(jogDTO.getNome(), jogDTO.getPernaBoa(), jogDTO.getPosicao(), jogDTO.getAltura(), jogDTO.getPeso(), jogDTO.getContrato(), jogDTO.getNacionalidade(), jogDTO.getDataNasc());
            return new ResponseEntity<>("Jogador Cadastrado", HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>("Erro ao cadastrar jogador: " +e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //DELETE BY ID
    @DeleteMapping("/{id}")
    public void delJogador(@PathVariable Long id) {
        jogadorRepo.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJogador(@PathVariable Long id, @RequestBody JogadorDTO jogDto) {
        try {
            Optional<JogadorModel> jogFromDb = jogadorRepo.findById(id);
        }
    }
}
