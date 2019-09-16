package com.hotel.controller.dto;

import com.hotel.entity.Hospede;

import javax.persistence.Column;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HospedeDto implements Serializable {

    private Long id;
    private String nome;
    private String documento;
    private String telefone;

    private BigDecimal valorHospedagemAtual;
    private BigDecimal valorUltimaHospedagem;

    public HospedeDto(Hospede hospede) {
        this.id = hospede.getId();
        this.nome = hospede.getNome();
        this.documento = hospede.getDocumento();
        this.telefone = hospede.getTelefone();

//        this.valorHospedagemAtual = hospede.getTotalHospedagemAtual();
//        this.valorUltimaHospedagem = hospede.getTotalHospedagemAnterior();
    }

    public static List<HospedeDto> from(List<Hospede> hospedes) {
        return hospedes.stream().map(hospede ->  new HospedeDto(hospede)).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public BigDecimal getValorHospedagemAtual() {
        return valorHospedagemAtual;
    }

    public void setValorHospedagemAtual(BigDecimal valorHospedagemAtual) {
        this.valorHospedagemAtual = valorHospedagemAtual;
    }

    public BigDecimal getValorUltimaHospedagem() {
        return valorUltimaHospedagem;
    }

    public void setValorUltimaHospedagem(BigDecimal valorUltimaHospedagem) {
        this.valorUltimaHospedagem = valorUltimaHospedagem;
    }
}
