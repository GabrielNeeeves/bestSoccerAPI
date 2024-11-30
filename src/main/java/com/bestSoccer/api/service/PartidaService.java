package com.bestSoccer.api.service;

<<<<<<< HEAD
=======
import com.bestSoccer.api.model.PartidaModel;
import com.bestSoccer.api.repository.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> 8d1a811845ebbdb5c87c677cfe98c927da441271
import org.springframework.stereotype.Service;

@Service
public class PartidaService {

<<<<<<< HEAD
=======
    @Autowired
    private PartidaRepository partidaRepository;

    //UPDATE BY ID
    public PartidaModel updatePorId(Long id, PartidaModel novaPartida) {
        novaPartida.setId(id);
        return partidaRepository.save(novaPartida);
    }


>>>>>>> 8d1a811845ebbdb5c87c677cfe98c927da441271
}
