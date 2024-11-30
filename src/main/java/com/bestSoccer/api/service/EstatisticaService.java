package com.bestSoccer.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bestSoccer.api.model.EstatisticaModel;
import com.bestSoccer.api.repository.EstatisticaRepository;
@Service
public class EstatisticaService {

    @Autowired
    private EstatisticaRepository estatisticaRepository;


    public EstatisticaModel saveEstatisticas(EstatisticaModel estatisticas) {
        return estatisticaRepository.save(estatisticas);
    }
}

