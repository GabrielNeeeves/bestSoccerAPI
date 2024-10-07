package com.bestSoccer.api.model.DTO;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

public class PartidaDTO {

    private Date data;
    private LocalTime hora;
    private String timeadv;
    private String local;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getTimeadv() {
        return timeadv;
    }

    public void setTimeadv(String timeadv) {
        this.timeadv = timeadv;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
