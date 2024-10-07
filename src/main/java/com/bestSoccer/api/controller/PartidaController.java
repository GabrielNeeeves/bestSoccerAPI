package com.bestSoccer.api.controller;

import com.bestSoccer.api.model.DTO.PartidaDTO;
import com.bestSoccer.api.model.PartidaModel;
import com.bestSoccer.api.repository.PartidaRepository;
import com.bestSoccer.api.service.PartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/partidas")
public class PartidaController {

    @Autowired
    private PartidaRepository partidaRepository;

    @Autowired
    private PartidaService partidaService;

    //GET
    @GetMapping
    public ResponseEntity<List<PartidaModel>> getPartida() {
        return ResponseEntity.ok(partidaRepository.findAll());
    }

    //POST
    @PostMapping()
    public ResponseEntity<String> postPartida(@RequestBody PartidaDTO partidaDTO) {
        try {
            partidaRepository.cadPartida(partidaDTO.getData(), partidaDTO.getHora(), partidaDTO.getTimeadv(), partidaDTO.getLocal());
            return new ResponseEntity<>("Jogador Cadastrado", HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>("Erro ao cadastrar: "+e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //DELETE BY ID
    @DeleteMapping("/{id}")
    public void delPartida(@PathVariable Long id) {
        partidaRepository.deleteById(id);
    }

    //PUT BY ID
    @PutMapping("/{id}")
    public ResponseEntity<PartidaModel> updatePartida(@PathVariable Long id, @RequestBody PartidaModel novaPartida) {
        try {
            PartidaModel nvPartida = partidaService.updatePorId(id, novaPartida);
            return ResponseEntity.ok(novaPartida);
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
