package com.example.mappers.controllers;

import com.example.mappers.dtos.DomicilioDTO;
import com.example.mappers.entities.Domicilio;
import com.example.mappers.services.DomicilioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/domicilios")
public class DomicilioController extends BaseControllerImpl<Domicilio, DomicilioDTO> {

    @Autowired
    private DomicilioServiceImpl service;

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody DomicilioDTO dto) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(service.save(dto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\": \"Error. Por favor intente mas tarde\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody DomicilioDTO dto) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(service.update(id, dto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\": \"Error. Por favor intente mas tarde\"}");
        }
    }

}
