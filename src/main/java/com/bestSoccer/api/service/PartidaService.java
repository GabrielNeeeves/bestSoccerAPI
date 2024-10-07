package com.bestSoccer.api.service;

import com.bestSoccer.api.model.PartidaModel;
import com.bestSoccer.api.repository.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartidaService {

    @Autowired
    private PartidaRepository partidaRepository;

    //UPDATE BY ID
    public PartidaModel updatePorId(Long id, PartidaModel novaPartida) {
        novaPartida.setId(id);
        return partidaRepository.save(novaPartida);
    }


}
