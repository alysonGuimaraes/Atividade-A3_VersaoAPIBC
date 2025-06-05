package com.bca3.valoresareceber.dto;

import com.bca3.valoresareceber.validators.ValidCpf;

import java.math.BigDecimal;
import java.util.Date;

public class ValoresReceberRequestDTO {
    public String nomeInstituicao;
    public String cnpj;
    public BigDecimal valor;
    public String tipoValor;
    public String observacao;
    public Date dtaReferencia;

    @ValidCpf
    public String cpf;
}
