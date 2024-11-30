package com.bestSoccer.api.controller;

import com.bestSoccer.api.model.PartidaView;
import com.bestSoccer.api.repository.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/partidas")
public class PartidaController {

    @Autowired
    private PartidaRepository partidaRepository;

    @GetMapping
    public ResponseEntity<List<PartidaView>> getPartida() {
        List<PartidaView> partidas = partidaRepository.findAllPartida(); 
        return ResponseEntity.ok(partidas);
    }

    }

