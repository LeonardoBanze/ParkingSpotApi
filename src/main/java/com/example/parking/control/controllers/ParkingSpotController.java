package com.example.parking.control.controllers;


import com.example.parking.control.dtos.ParkingSpotDto;
import com.example.parking.control.models.ParkingSpotModel;
import com.example.parking.control.services.ParkingSpotService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spot")
public class ParkingSpotController {


    @Autowired
    ParkingSpotService parkingSpotService;


//    O objetivo principal do ResponseEntity é fornecer uma maneira flexível de construir e retornar respostas HTTP personalizadas a partir de um controlador.
//    Ele permite que você defina o corpo da resposta, os cabeçalhos e o código de status de forma programática.
    @PostMapping("/")
    public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDto parkingSpotDto){
        var parkingSpotModel = new ParkingSpotModel();
        BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel);
        parkingSpotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.save(parkingSpotModel));
    }


}
