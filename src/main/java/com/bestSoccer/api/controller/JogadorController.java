package com.bestSoccer.api.controller;

import com.bestSoccer.api.model.DTO.JogadorDTO;
import com.bestSoccer.api.model.JogadorModel;
import com.bestSoccer.api.repository.JogadorRepository;
import com.bestSoccer.api.service.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/jogadores")
public class JogadorController {

    @Autowired
    private JogadorRepository jogadorRepository;

    @Autowired
    private JogadorService jogadorService;

    //GET
    @GetMapping
    public ResponseEntity<List<JogadorModel>> getJogador() {
        return ResponseEntity.ok(jogadorRepository.findAll());
    }

    //FIND BY ID
    @GetMapping("/{id}")
    public ResponseEntity<JogadorModel> findById(@PathVariable Long id) {

           Optional<JogadorModel> optJogador = jogadorRepository.findById(id);
           if(optJogador.isPresent()) return ResponseEntity.ok(optJogador.get());
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    //POST
    @PostMapping
    public ResponseEntity<String> postJogador(@RequestBody JogadorDTO jogDTO) {
        try {
            jogadorRepository.cadJogador(jogDTO.getNome(), jogDTO.getPernaBoa(), jogDTO.getPosicao(), jogDTO.getAltura(), jogDTO.getPeso(), jogDTO.getContrato(), jogDTO.getNacionalidade(), jogDTO.getDataNasc());
            return new ResponseEntity<>("Jogador Cadastrado", HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>("Erro ao cadastrar jogador: " +e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //DELETE BY ID
    @DeleteMapping("/{id}")
    public void delJogador(@PathVariable Long id) {
        jogadorRepository.deleteById(id);
    }

    //PUT BY ID
    @PutMapping("/{id}")
    public ResponseEntity<JogadorModel> updateJogador(@PathVariable Long id, @RequestBody JogadorModel novoJogador) {
        try {
            JogadorModel nvJog = jogadorService.updatePorId(id, novoJogador);
            return ResponseEntity.ok(nvJog);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);

        }
    }


}
