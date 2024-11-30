package com.bestSoccer.api.controller;

<<<<<<< HEAD
import com.bestSoccer.api.model.JogadorView;
import com.bestSoccer.api.repository.JogadorRepository;
import com.bestSoccer.api.service.JogadorService;

=======
import com.bestSoccer.api.model.DTO.JogadorDTO;
import com.bestSoccer.api.model.JogadorModel;
import com.bestSoccer.api.repository.JogadorRepository;
import com.bestSoccer.api.service.JogadorService;
>>>>>>> 8d1a811845ebbdb5c87c677cfe98c927da441271
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
<<<<<<< HEAD

@RestController
@RequestMapping("/jogadores")
=======
import java.util.Optional;

@RestController
@RequestMapping(value = "/jogadores")
>>>>>>> 8d1a811845ebbdb5c87c677cfe98c927da441271
public class JogadorController {

    @Autowired
    private JogadorRepository jogadorRepository;

    @Autowired
    private JogadorService jogadorService;

<<<<<<< HEAD
    @GetMapping
    public ResponseEntity<List<JogadorView>> getJogadores() {
        List<JogadorView> jogadores = jogadorRepository.findAllJogadores();
        return ResponseEntity.ok(jogadores);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<String> postJogador(@RequestBody JogadorView jogadorView) {
        try {
            jogadorRepository.cadJogador(
                jogadorView.getNome(),
                jogadorView.getPernadominante(),
                jogadorView.getPosicao(),
                jogadorView.getAltura(),
                jogadorView.getPeso(),
                jogadorView.getContrato(),
                jogadorView.getNacionalidade(),
                jogadorView.getDatanascimento(),
                jogadorView.getFoto()
            );
            return new ResponseEntity<>("Jogador Cadastrado com Sucesso", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao cadastrar o jogador: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<JogadorView> getJogadorById(@PathVariable Long id) {
        JogadorView jogador = jogadorService.selectPorId(id);
        return ResponseEntity.ok(jogador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJogadorById(@PathVariable Long id) {
        try {
            jogadorService.deletarPorId(id);
            return new ResponseEntity<>("Jogador deletado com sucesso", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao deletar o jogador: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<String> updateJogadorById(@PathVariable Long id, @RequestBody JogadorView jogadorAtualizado) {
        try {
            jogadorService.atualizarPorId(id, jogadorAtualizado);
            return new ResponseEntity<>("Jogador atualizado com sucesso", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao atualizar o jogador: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
=======
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


>>>>>>> 8d1a811845ebbdb5c87c677cfe98c927da441271
}
