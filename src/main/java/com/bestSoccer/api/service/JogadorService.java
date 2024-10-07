package com.bestSoccer.api.service;

import com.bestSoccer.api.model.JogadorModel;
import com.bestSoccer.api.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository jogRepo;

    //autalizar por id
    public void updateJogador(Long id, JogadorModel novoJogModel) {
        Optional<JogadorModel> jogPres = jogRepo.findById(id);
        if(jogPres.isPresent()) {
            JogadorModel nvJog = jogPres.get();
            nvJog.setNome(novoJogModel.getNome());
            nvJog.setPernaBoa(novoJogModel.getPernaBoa());
            nvJog.setPosicao(novoJogModel.getPosicao());
            nvJog.setAltura(novoJogModel.getAltura());
            nvJog.setPeso(novoJogModel.getPeso());
            nvJog.setContrato(novoJogModel.getContrato());
            nvJog.setNacionalidade(novoJogModel.getNacionalidade());
            nvJog.setDataNascimento(novoJogModel.getDataNascimento());

        }

    }

    //update por id
    public JogadorModel updatePorId(Long id, JogadorModel nvJogador) {
        nvJogador.setId(id);
        return jogRepo.save(nvJogador);
    }

}
