package br.csi.apppostodesaude.model;

import java.sql.Date;
import java.sql.Timestamp;

public class Consulta {
    private int id;
    private String data;
    private String hora;
    private String caso;
    private Paciente paciente;
    private Medico medico;

    private boolean status_consulta;

    public Consulta() {
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getCaso() {
        return caso;
    }

    public void setCaso(String caso) {
        this.caso = caso;
    }



    public boolean isStatus_consulta() {
        return status_consulta;
    }

    public void setStatus_consulta(boolean status_consulta) {
        this.status_consulta = status_consulta;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
