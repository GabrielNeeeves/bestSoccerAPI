package com.bestSoccer.api.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

@Embeddable
public class PartidaJogadorId implements Serializable {

    private Integer partidaid;
    private Integer jogadorid;

    public PartidaJogadorId(){}

    public PartidaJogadorId(Integer partidaid, Integer jogadorid) {
        this.partidaid = partidaid;
        this.jogadorid = jogadorid;
    }

    public Integer getPartidaId() {
        return partidaid;
    }

    public void setPartidaId(Integer partidaId) {
        this.partidaid = partidaId;
    }

    public Integer getJogadorId() {
        return jogadorid;
    }

    public void setJogadorId(Integer jogadorId) {
        this.jogadorid = jogadorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PartidaJogadorId that = (PartidaJogadorId) o;
        return Objects.equals(partidaid, that.partidaid) && Objects.equals(jogadorid, that.jogadorid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(partidaid, jogadorid);
    }
}
