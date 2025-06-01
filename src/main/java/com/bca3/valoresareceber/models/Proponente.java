package com.bca3.valoresareceber.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import java.util.Objects;

@Entity
@Table(name="proponente")
public class Proponente {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(length = 11, nullable = false, unique = true)
    private String cpf;

    @Column(name = "dta_nascimento", nullable = false)
    private LocalDate dtaNascimento;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDtaNascimento() {
        return dtaNascimento;
    }

    public void setDtaNascimento(LocalDate dtaNascimento) {
        this.dtaNascimento = dtaNascimento;
    }
}
