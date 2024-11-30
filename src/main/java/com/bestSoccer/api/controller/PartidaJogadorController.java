package com.bestSoccer.api.controller;

import com.bestSoccer.api.model.PartidaJogadorModel;
import com.bestSoccer.api.service.PartidaJogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping(value = "/partida_jogador")
public class PartidaJogadorController {

    @Autowired
    private PartidaJogadorService service;

    //GET
    @GetMapping
    public ResponseEntity<List<PartidaJogadorModel>> getPartidaJogador() {
        return service.getPartidaJogador();
    }

    //POST
    @PostMapping
    public void postPartidaJogador(@RequestBody PartidaJogadorModel pjm) {
        service.postPartidaJogador(pjm);
    }

    //PUT
    @PutMapping("/partidaid/{partidaid}/jogadorid/{jogadorid}")
    public void postPartidaJogador(
            @PathVariable Integer partidaid,
            @PathVariable Integer jogadorid,
            @RequestBody PartidaJogadorModel nvPartidaJog
    ) {
        service.updatePartidaJogador(partidaid, jogadorid, nvPartidaJog);
    }

}
