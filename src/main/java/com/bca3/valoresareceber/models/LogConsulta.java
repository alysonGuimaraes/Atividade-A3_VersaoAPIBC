package com.bca3.valoresareceber.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "log_consulta")
public class LogConsulta {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "dta_consulta", nullable = false)
    private LocalDateTime dtaConsulta;

    @Column(name = "prop_no_banco", nullable = false)
    private boolean propNoBanco;

    @Column(name = "possui_valores", nullable = false)
    private boolean possuiValores;

    @Column(name = "cpf_consultado", nullable = false, length = 11)
    private String cpfConsultado;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getDtaConsulta() {
        return dtaConsulta;
    }

    public void setDtaConsulta(LocalDateTime dtaConsulta) {
        this.dtaConsulta = dtaConsulta;
    }

    public boolean isPropNoBanco() {
        return propNoBanco;
    }

    public void setPropNoBanco(boolean propNoBanco) {
        this.propNoBanco = propNoBanco;
    }

    public boolean isPossuiValores() {
        return possuiValores;
    }

    public void setPossuiValores(boolean possuiValores) {
        this.possuiValores = possuiValores;
    }

    public String getCpfConsultado() {
        return cpfConsultado;
    }

    public void setCpfConsultado(String cpfConsultado) {
        this.cpfConsultado = cpfConsultado;
    }
}

