package com.hotel.controller;

import com.hotel.controller.dto.HospedeDto;
import com.hotel.controller.filtro.CheckInFiltro;
import com.hotel.entity.Hospede;
import com.hotel.service.HospedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
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

    @DeleteMapping(value = "/{hospedeId}")
    public ResponseEntity<?> delete(@PathVariable Long hospedeId) {
        hospedeService.delete(hospedeId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/nome/")
    public ResponseEntity<?> getHospedesByNome(@RequestParam String nome){
        List<Hospede> hospedes = hospedeService.getHospedeByNome(nome);
        return ResponseEntity.ok(HospedeDto.from(hospedes));
    }

    @PostMapping(value = "/filtro")
    public ResponseEntity<?> getHospedesByFiltro(@RequestBody CheckInFiltro checkInFiltro){
        List<Hospede> hospedes = hospedeService.getHospedeByFiltro(checkInFiltro);
        return ResponseEntity.ok(HospedeDto.from(hospedes));
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        List<HospedeDto> hospedes = hospedeService.findAll();
        return ResponseEntity.ok(hospedes);
    }
}
