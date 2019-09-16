package com.hotel.entity;

import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class CheckIn {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PK_CHECK_IN_SEQ")
    @SequenceGenerator(name = "PK_CHECK_IN_SEQ", sequenceName = "PK_CHECK_IN_SEQ", allocationSize = 1)
//    @Column(name = "PK_CHECK_IN")
    private Long id;

//    @ManyToOne(fetch = FetchType.EAGER, optional = false)
//    @JoinColumn(name = "fk_hospede", referencedColumnName = "PK_HOSPEDE")
//    private Hospede hospede;
    @ManyToOne //(fetch = FetchType.LAZY)
    private Hospede hospede;

    @NotNull
    private LocalDateTime dataEntrada;

    private LocalDateTime dataSaida;

    private Boolean adicionalVeiculo = Boolean.FALSE;

    public Long getId() {
        return id;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
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
