package com.hotel.service;

import com.hotel.controller.dto.HospedeDto;
import com.hotel.core.exception.GenericException;
import com.hotel.entity.CheckIn;
import com.hotel.entity.Hospede;
import com.hotel.repository.HospedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HospedeService {

    @Autowired
    private HospedeRepository hospedeRepository;

    @Autowired
    private FinanceiroService financeiroService;

    @Autowired
    private CheckInService checkInService;

    public Hospede save(Hospede hospede) {
        return hospedeRepository.save(hospede);
    }

    public List<HospedeDto> findAll() {
        List<Hospede> hospedes = hospedeRepository.findAll();

        List<HospedeDto> hospedeDtoList = new ArrayList<>();
        for (Hospede hospede: hospedes) {
            List<CheckIn> checkIn = hospede.getCheckIn();
            HospedeDto hospedeDto = new HospedeDto(hospede);

            hospedeDto.setValorHospedagemAtual(financeiroService.getValorEstadia(checkInService.getCheckInAtual(checkIn)));
            hospedeDto.setValorUltimaHospedagem(financeiroService.getValorEstadia(checkInService.getCheckInAnterior(checkIn)));

            hospedeDtoList.add(hospedeDto);
        }

        return hospedeDtoList;
    }

    public void delete(Long id) {
        Optional<Hospede> obj = hospedeRepository.findById(id);
        if (obj.isPresent()) {
            try {
                hospedeRepository.delete(obj.get());
                return;
            } catch (Exception e) {
                throw new GenericException(e.getMessage());
            }
        }

        throw new GenericException("Hospede não encontrado");
    }

    public List<Hospede> getHospedeByNome(String nome) throws GenericException {
        List<Hospede> hospedes = hospedeRepository.getHospedesByNomeContainingIgnoreCase(nome);
        return hospedes;
    }

    public Optional<Hospede> getHospedeByDocumento(String Documento) throws GenericException {
        return hospedeRepository.getHospedesByDocumentoContaining(Documento);
    }

    public List<Hospede> getHospedeByTelefone(String telefone) throws GenericException {
        return hospedeRepository.getHospedesByTelefoneContaining(telefone);
    }

    public Optional<Hospede> getHospedesAnteriores() {
        return hospedeRepository.getHospedesAnteriores();
    }

    public Optional<Hospede> getHospedesAtuais() {
        return hospedeRepository.getHospedesAtuais();
    }
}
