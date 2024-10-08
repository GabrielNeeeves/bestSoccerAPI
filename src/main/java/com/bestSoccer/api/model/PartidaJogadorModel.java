package com.bestSoccer.api.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;

@Entity
@Table(name = "Partidajogadores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@IdClass(PartidaJogadorId.class)
public class PartidaJogadorModel {

//    @Id
//    @JoinColumn(name = "partidaid", insertable = false, updatable = false)
//    private Long partidaid;
//
//    @Id
//    @JoinColumn(name = "jogadorid", insertable = false, updatable = false)
//    private Long jogadorid;

    @Column(nullable = false)
    private Integer gols;

    @EmbeddedId
    private PartidaJogadorId partidaJogadorId;

    public Integer getGols() {
        return gols;
    }

    public void setGols(Integer gols) {
        this.gols = gols;
    }

    public PartidaJogadorId getPartidaJogadorId() {
        return partidaJogadorId;
    }

    public void setPartidaJogadorId(PartidaJogadorId partidaJogadorId) {
        this.partidaJogadorId = partidaJogadorId;
    }

    //    public Long getPartidaid() {
//    return partidaid;
//    }
//
//    public void setPartidaid(Long partidaid) {
//        this.partidaid = partidaid;
//    }
//
//    public Long getJogadorid() {
//        return jogadorid;
//    }
//
//    public void setJogadorid(Long jogadorid) {
//        this.jogadorid = jogadorid;
//    }

}
