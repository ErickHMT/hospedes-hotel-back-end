package com.hotel.service;

import com.hotel.controller.dto.HospedeDto;
import com.hotel.controller.filtro.CheckInFiltro;
import com.hotel.core.exception.GenericException;
import com.hotel.entity.CheckIn;
import com.hotel.entity.Hospede;
import com.hotel.repository.HospedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<Hospede> getHospedeByNome(String nome) {
        return hospedeRepository.getHospedesByNomeContainingIgnoreCase(nome);
    }
    
    public List<Hospede> getHospedeByFiltro(CheckInFiltro checkInFiltro) throws GenericException {
        List<Hospede> hospedes = hospedeRepository.getHospedeByFiltro(checkInFiltro.getNome(),
                checkInFiltro.getDocumento(),
                checkInFiltro.getTelefone());

        // Filtra hospedes pelo parametro "hospedePresente"
        return hospedes.stream().filter(hospede -> {
            CheckIn checkInAtual = checkInService.getCheckInAtual(hospede.getCheckIn());
            if (checkInFiltro.isHospedePresente()) {
                return checkInAtual != null;
            } else {
                return checkInAtual == null;
            }
        }).collect(Collectors.toList());
    }
}
