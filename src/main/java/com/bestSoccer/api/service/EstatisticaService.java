package com.bestSoccer.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bestSoccer.api.model.estatistica.EstatisticaModel;
import com.bestSoccer.api.model.estatistica.EstatisticaView;
import com.bestSoccer.api.repository.estatistica.EstatisticaRepository;

@Service
public class EstatisticaService {

    @Autowired
    private EstatisticaRepository estatisticaRepository;


    public EstatisticaModel saveEstatisticas(EstatisticaModel estatisticas) {
        return estatisticaRepository.save(estatisticas);
    }

    public void cadastrarEstatisticas(int jogadorId, EstatisticaView estatisticas) {
        estatisticaRepository.cadEstatisticaJogador(
            jogadorId,
            estatisticas.getJogosdisputados(),
            estatisticas.getGolsmarcados(),
            estatisticas.getAssistencias(),
            estatisticas.getFinalizacoes(),
            estatisticas.getPasses(),
            estatisticas.getDesarmes(),
            estatisticas.getFaltascometidas(),
            estatisticas.getCartoesamarelos(),
            estatisticas.getCartoesvermelhos()
        );
    }


    public void atualizarEstatisticas(Long id, EstatisticaView estatisticas) {
        EstatisticaModel estatisticaModel = estatisticaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Estatísticas não encontradas para o ID: " + id));
    
        estatisticas.setJogosdisputados(estatisticas.getJogosdisputados());
        estatisticas.setGolsmarcados(estatisticas.getGolsmarcados());
        estatisticas.setAssistencias(estatisticas.getAssistencias());
        estatisticas.setFinalizacoes(estatisticas.getFinalizacoes());
        estatisticas.setPasses(estatisticas.getPasses());
        estatisticas.setDesarmes(estatisticas.getDesarmes());
        estatisticas.setFaltascometidas(estatisticas.getFaltascometidas());
        estatisticas.setCartoesamarelos(estatisticas.getCartoesamarelos());
        estatisticas.setCartoesvermelhos(estatisticas.getCartoesvermelhos());
    
        estatisticaRepository.save(estatisticaModel);
    }
}
