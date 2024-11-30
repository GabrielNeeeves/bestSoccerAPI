package com.bestSoccer.api.controller;

import com.bestSoccer.api.model.EstatisticaView;
import com.bestSoccer.api.repository.EstatisticaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/estatisticas-jogador")
public class EstatisticasJogadorController {

    @Autowired
    private EstatisticaRepository estatisticaRepository;

@GetMapping("/{id}")
public ResponseEntity<EstatisticaView> getEstatisticas(@PathVariable Long id) {
    EstatisticaView estatisticas = estatisticaRepository.findEstatisticasByJogadorId(id);
    if (estatisticas != null) {
        return ResponseEntity.ok(estatisticas);
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
}
}
