package com.hotel.controller;

import com.hotel.controller.dto.HospedeDto;
import com.hotel.entity.Hospede;
import com.hotel.service.HospedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/hospedes")
public class HospedeController extends ResponseAbstractController {

    @Autowired
    private HospedeService hospedeService;

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody @Valid Hospede hospede, UriComponentsBuilder uriBuilder){
        hospedeService.save(hospede);
        URI uri = uriBuilder.path("/hospedes/documento/{documento}").buildAndExpand(hospede.getDocumento()).toUri();
        return ResponseEntity.created(uri).body(new HospedeDto(hospede));
    }

    @GetMapping(value = "/nome/{nomeHospede}")
    public ResponseEntity<?> getHospedeByNome(@PathVariable String nomeHospede){
        Optional<Hospede> hospede = hospedeService.getHospedeByNome(nomeHospede);
        if(hospede.isPresent()) {
            return ResponseEntity.ok(new HospedeDto(hospede.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/documento/{documento}")
    public ResponseEntity<?> getHospedeByDocumento(@PathVariable String documento){
        Optional<Hospede> hospede = hospedeService.getHospedeByDocumento(documento);
        if(hospede.isPresent()) {
            return ResponseEntity.ok(new HospedeDto(hospede.get()));
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping(value = "/telefone/{telefone}")
    public List<HospedeDto> getHospedeByTelefone(@PathVariable String telefone){
        List<Hospede> hospedes = hospedeService.getHospedeByTelefone(telefone);
        if(!hospedes.isEmpty()) {
            List<HospedeDto> teste = HospedeDto.from(hospedes);
            return teste;
        }
        return (List<HospedeDto>) ResponseEntity.notFound().build();
    }


    @GetMapping(value = "/anteriores")
    public ResponseEntity<?> getHospedesAnteriores(){
        Optional<Hospede> hospede = hospedeService.getHospedesAnteriores();

        if(hospede.isPresent()) {
            return ResponseEntity.ok(hospede);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/atuais")
    public ResponseEntity<?> getHospedesAtuais(){
        Optional<Hospede> hospede = hospedeService.getHospedesAtuais();

        if(hospede.isPresent()) {
            return ResponseEntity.ok(hospede);
        }
        return ResponseEntity.notFound().build();
    }

}
