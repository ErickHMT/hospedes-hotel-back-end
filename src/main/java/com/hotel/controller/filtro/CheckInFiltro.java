package com.hotel.controller.filtro;

public class CheckInFiltro {

    private String nome;
    private String documento;
    private String telefone;
    private boolean hospedePresente;

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

    public boolean isHospedePresente() {
        return hospedePresente;
    }

    public void setHospedePresente(boolean hospedePresente) {
        this.hospedePresente = hospedePresente;
    }
}
