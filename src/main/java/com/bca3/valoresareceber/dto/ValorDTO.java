package com.bca3.valoresareceber.dto;

import java.math.BigDecimal;
import java.util.Date;

public class ValorDTO {
    private String nomeInstituicao;
    private String cnpj;
    private BigDecimal valor;
    private String tipoValor;
    private String observacao;
    private Date dtaReferencia;

    public ValorDTO(String nomeInstituicao, String cnpj, BigDecimal valor, String tipoValor, String observacao, Date dtaReferencia) {
        this.nomeInstituicao = nomeInstituicao;
        this.cnpj = cnpj;
        this.valor = valor;
        this.tipoValor = tipoValor;
        this.observacao = observacao;
        this.dtaReferencia = dtaReferencia;
    }

    // Getters e Setters
    public String getNomeInstituicao() {
        return nomeInstituicao;
    }

    public void setNomeInstituicao(String nomeInstituicao) {
        this.nomeInstituicao = nomeInstituicao;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getTipoValor() {
        return tipoValor;
    }

    public void setTipoValor(String tipoValor) {
        this.tipoValor = tipoValor;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getDtaReferencia() {
        return dtaReferencia;
    }

    public void setDtaReferencia(Date dtaReferencia) {
        this.dtaReferencia = dtaReferencia;
    }
}
