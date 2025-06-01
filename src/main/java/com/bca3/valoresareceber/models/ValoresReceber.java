package com.bca3.valoresareceber.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "valores_receber")
public class ValoresReceber {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "nome_instituicao", length = 25, nullable = false)
    private String nomeInstituicao;

    @Column(length = 14, nullable = false)
    private String cnpj;

    @Column(precision = 7, scale = 2, nullable = false)
    private BigDecimal valor;

    @Column(name = "tipo_valor", length = 30, nullable = false)
    private String tipoValor;

    @Column(length = 60)
    private String observacao;

    @Column(name = "dta_referencia", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dtaReferencia;

    @ManyToOne
    @JoinColumn(name = "id_prop", nullable = false)
    private Proponente proponente;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    public Proponente getProponente() {
        return proponente;
    }

    public void setProponente(Proponente proponente) {
        this.proponente = proponente;
    }
}
