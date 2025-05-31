package com.bca3.valoresareceber.dto;

import java.util.List;

public class valoresReceberResDTO {
    private String mensagem;
    private String nomeProponente;
    private List<ValorDTO> valores;

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getNomeProponente() {
        return nomeProponente;
    }

    public void setNomeProponente(String nomeProponente) {
        this.nomeProponente = nomeProponente;
    }

    public List<ValorDTO> getValores() {
        return valores;
    }

    public void setValores(List<ValorDTO> valores) {
        this.valores = valores;
    }
}
