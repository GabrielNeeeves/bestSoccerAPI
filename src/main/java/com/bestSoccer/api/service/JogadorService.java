package com.bestSoccer.api.service;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bestSoccer.api.model.JogadorView;
import com.bestSoccer.api.repository.JogadorRepository;

import jakarta.transaction.Transactional;
=======
import com.bestSoccer.api.model.JogadorModel;
import com.bestSoccer.api.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
>>>>>>> 8d1a811845ebbdb5c87c677cfe98c927da441271

@Service
public class JogadorService {

    @Autowired
<<<<<<< HEAD
    private JogadorRepository jogadorRepository;

    public JogadorView selectPorId(Long id) {
        JogadorView jogador = jogadorRepository.findJogadorById(id);
        if (jogador == null) {
            throw new RuntimeException("Jogador com ID " + id + " não foi encontrado");
        }
        return jogador;
    }

    @Transactional
    public void deletarPorId(Long id) {
        JogadorView jogador = jogadorRepository.findJogadorById(id);
        if (jogador == null) {
            throw new RuntimeException("Jogador com ID " + id + " não foi encontrado");
        }
        jogadorRepository.deleteJogadorById(id);
    }

    @Transactional
    public void atualizarPorId(Long id, JogadorView jogadorAtualizado) {
        JogadorView jogador = jogadorRepository.findJogadorById(id);
        if (jogador == null) {
            throw new RuntimeException("Jogador com ID " + id + " não foi encontrado");
        }
        jogadorRepository.updateJogadorById(
            id,
            jogadorAtualizado.getNome(),
            jogadorAtualizado.getPernadominante(),
            jogadorAtualizado.getPosicao(),
            jogadorAtualizado.getAltura(),
            jogadorAtualizado.getPeso(),
            jogadorAtualizado.getContrato(),
            jogadorAtualizado.getNacionalidade(),
            jogadorAtualizado.getDatanascimento(),
            jogadorAtualizado.getFoto()
        );
    }

    

=======
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

>>>>>>> 8d1a811845ebbdb5c87c677cfe98c927da441271
}
