package com.hotel.controller;

import com.hotel.controller.dto.CheckInDto;
import com.hotel.entity.CheckIn;
import com.hotel.service.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/check-in")
public class CheckInController {

    @Autowired
    CheckInService checkInService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        List<CheckIn> checkInList = checkInService.findAll();
        List<CheckInDto> from = CheckInDto.from(checkInList);
        return ResponseEntity.ok(from);
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody @Valid CheckIn checkIn, UriComponentsBuilder uriBuilder){
        checkInService.save(checkIn);
//        URI uri = uriBuilder.path("/hospedes/documento/{documento}").buildAndExpand(checkIn.getDocumento()).toUri();
//        return ResponseEntity.created(uri).body(new HospedeDto(checkIn));
        return new ResponseEntity(HttpStatus.OK);
    }

}
