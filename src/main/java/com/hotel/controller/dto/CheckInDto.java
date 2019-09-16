package com.hotel.controller.dto;

import com.hotel.entity.CheckIn;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class CheckInDto implements Serializable {

    private Long id;
    private HospedeDto hospede;
    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;
    private Boolean adicionalVeiculo;

    public CheckInDto(CheckIn checkIn) {
        this.id = checkIn.getId();
        this.hospede = new HospedeDto(checkIn.getHospede());
        this.dataEntrada = checkIn.getDataEntrada();
        this.dataSaida = checkIn.getDataSaida();
        this.adicionalVeiculo = checkIn.getAdicionalVeiculo();
    }

    public static List<CheckInDto> from(List<CheckIn> hospedes) {
        return hospedes.stream().map(hospede ->  new CheckInDto(hospede)).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HospedeDto getHospede() {
        return hospede;
    }

    public void setHospede(HospedeDto hospede) {
        this.hospede = hospede;
    }

    public LocalDateTime getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDateTime dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDateTime getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDateTime dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Boolean getAdicionalVeiculo() {
        return adicionalVeiculo;
    }

    public void setAdicionalVeiculo(Boolean adicionalVeiculo) {
        this.adicionalVeiculo = adicionalVeiculo;
    }

}
