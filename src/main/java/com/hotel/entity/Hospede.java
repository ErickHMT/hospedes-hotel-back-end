package com.hotel.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Hospede {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PK_HOSPEDE_SEQ")
    @SequenceGenerator(name = "PK_HOSPEDE_SEQ", sequenceName = "PK_HOSPEDE_SEQ", allocationSize = 1)
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    private String documento;

    @NotNull
    private String telefone;

    @OneToMany(mappedBy = "hospede")
    private List<CheckIn> checkIn;

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

    public List<CheckIn> getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(List<CheckIn> checkIn) {
        this.checkIn = checkIn;
    }
}
