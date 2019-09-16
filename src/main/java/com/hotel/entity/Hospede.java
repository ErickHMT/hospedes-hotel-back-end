package com.hotel.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hotel.service.CalculaValorHospedagem;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Hospede {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PK_HOSPEDE_SEQ")
    @SequenceGenerator(name = "PK_HOSPEDE_SEQ", sequenceName = "PK_HOSPEDE_SEQ", allocationSize = 1)
//    @Column(name = "PK_HOSPEDE")
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    private String documento;

    @NotNull
    private String telefone;

    @OneToMany(mappedBy = "hospede", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CheckIn> checkIn;

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

    public List<CheckIn> getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(List<CheckIn> checkIn) {
        this.checkIn = checkIn;
    }

    public Hospede getValorGastoHospede(){
        return null;
    }

    public BigDecimal getTotalHospedagemAtual(){
//        List<CheckIn> checkInList = getCheckIn();
//        if(checkInList == null || checkInList.isEmpty()){
//            return null;
//        }
//
//        CheckIn checkIn = getCheckIn().get(checkInList.size());
//        return CalculaValorHospedagem.getValorTotalHospedagem(checkIn);

        return null;
    }

    public BigDecimal getTotalHospedagemAnterior(){
//        List<CheckIn> checkInList = getCheckInList();
//        if(checkInList != null || checkInList.size() > 1) {
//            CheckIn checkInAnterior = checkInList.get(checkInList.size() - 1);
//            return CalculaValorHospedagem.getValorTotalHospedagem(checkInAnterior);
//        }
        return null;
    }
}
