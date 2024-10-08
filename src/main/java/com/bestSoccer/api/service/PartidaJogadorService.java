package com.bestSoccer.api.service;

import com.bestSoccer.api.model.PartidaJogadorId;
import com.bestSoccer.api.model.PartidaJogadorModel;
import com.bestSoccer.api.repository.PartidaJogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigInteger;
import java.util.List;

@Service
public class PartidaJogadorService {

    @Autowired
    private PartidaJogadorRepository repo;

    //GET
    public ResponseEntity<List<PartidaJogadorModel>> getPartidaJogador() {
        List<PartidaJogadorModel> lista = repo.findAll();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    //POST
    public ResponseEntity<String> postPartidaJogador(@RequestBody PartidaJogadorModel nvParJog) {
        try {
            repo.cadPartidaJogador(nvParJog.getPartidaJogadorId().getPartidaId(), nvParJog.getPartidaJogadorId().getJogadorId(), nvParJog.getGols());
            return new ResponseEntity<>("Partida Jogador cadastrado", HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>("Erro ao cadastrar Partida Jogador", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //UPDATE BY ID
    public void updatePartidaJogador(
            @PathVariable Integer partidaid,
            @PathVariable Integer jogadorid,
            @RequestBody PartidaJogadorModel nvPartidaJog
    ) {
        PartidaJogadorId id = new PartidaJogadorId(partidaid, jogadorid);

        repo.findById(id).map(e -> {
            e.setGols(nvPartidaJog.getGols());
            repo.save(e);
            return ResponseEntity.ok(e);
        })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
