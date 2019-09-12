package com.hotel.service;

import com.hotel.controller.dto.HospedeDto;
import com.hotel.core.exception.GenericException;
import com.hotel.entity.CheckIn;
import com.hotel.entity.Hospede;
import com.hotel.repository.HospedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class HospedeService {

    @Autowired
    private HospedeRepository hospedeRepository;

    public Hospede save(Hospede hospede) {
        return hospedeRepository.save(hospede);
    }

    public Optional<Hospede> getHospedeByNome(String nome) throws GenericException {
        return hospedeRepository.getByNome(nome);
    }

    public Optional<Hospede> getHospedeByDocumento(String Documento) throws GenericException {
        Optional<Hospede> hospede = hospedeRepository.getHospedesByDocumento(Documento);
        return hospede;
    }

    public List<Hospede> getHospedeByTelefone(String telefone) throws GenericException {
        return hospedeRepository.getHospedesByTelefone(telefone);
    }

    public Optional<Hospede> getHospedesAnteriores() {
        return hospedeRepository.getHospedesAnteriores();
    }

    public Optional<Hospede> getHospedesAtuais() {
        return hospedeRepository.getHospedesAtuais();
    }
}
