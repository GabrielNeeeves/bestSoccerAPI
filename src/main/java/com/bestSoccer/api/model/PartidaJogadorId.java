package com.bestSoccer.api.model;

import java.io.Serializable;
import java.util.Objects;

public class PartidaJogadorId implements Serializable {

    private Long partidaId;
    private Long jogadorId;

    public Long getPartidaId() {
        return partidaId;
    }

    public void setPartidaId(Long partidaId) {
        this.partidaId = partidaId;
    }

    public Long getJogadorId() {
        return jogadorId;
    }

    public void setJogadorId(Long jogadorId) {
        this.jogadorId = jogadorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PartidaJogadorId that = (PartidaJogadorId) o;
        return Objects.equals(partidaId, that.partidaId) && Objects.equals(jogadorId, that.jogadorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(partidaId, jogadorId);
    }
}
