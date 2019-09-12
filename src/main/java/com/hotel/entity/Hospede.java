package com.hotel.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hotel.controller.dto.HospedeDto;
import com.hotel.service.CalculaValorHospedagem;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Hospede {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PK_HOSPEDE_SEQ")
    @SequenceGenerator(name = "PK_HOSPEDE_SEQ", sequenceName = "PK_HOSPEDE_SEQ", allocationSize = 1)
    @Column(name = "PK_HOSPEDE")
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    private String documento;

    @NotNull
    private String telefone;

//    @JsonIgnore
    @OneToMany(mappedBy = "hospede")
    private List<CheckIn> checkInList;

    public Long getId() {
        return id;
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

    public List<CheckIn> getCheckInList() {
        return checkInList;
    }

    public void setCheckInList(List<CheckIn> checkInList) {
        this.checkInList = checkInList;
    }

    public Hospede getValorGastoHospede(){
        return null;
    }

    public Double getTotalHospedagemAtual(){
        List<CheckIn> checkInList = getCheckInList();
        if(checkInList.isEmpty()){
            return null;
        }

        CheckIn checkIn = getCheckInList().get(checkInList.size());
        return CalculaValorHospedagem.getValorTotalHospedagem(checkIn);
    }

    public Double getTotalHospedagemAnterior(){
        List<CheckIn> checkInList = getCheckInList();
        if(checkInList.size() > 1) {
            CheckIn checkInAnterior = checkInList.get(checkInList.size() - 1);
            return CalculaValorHospedagem.getValorTotalHospedagem(checkInAnterior);
        }
        return null;
    }
}
