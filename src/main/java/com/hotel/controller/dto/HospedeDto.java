package com.hotel.controller.dto;

import com.hotel.entity.Hospede;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HospedeDto {

    private String nome;
    private String documento;
    private String telefone;

    private Double valorHospedagemAtual;
    private Double valorUltimaHospedagem;

    public HospedeDto(Hospede hospede) {
        this.nome = hospede.getNome();
        this.documento = hospede.getDocumento();
        this.telefone = hospede.getTelefone();

        this.valorHospedagemAtual = hospede.getTotalHospedagemAtual();
        this.valorUltimaHospedagem = hospede.getTotalHospedagemAnterior();
    }

    public static List<HospedeDto> from(List<Hospede> hospedes) {
        return hospedes.stream().map(hospede ->  new HospedeDto(hospede)).collect(Collectors.toList());
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setValorHospedagemAtual(Double valorHospedagemAtual) {
        this.valorHospedagemAtual = valorHospedagemAtual;
    }

    public void setValorUltimaHospedagem(Double valorUltimaHospedagem) {
        this.valorUltimaHospedagem = valorUltimaHospedagem;
    }
}
