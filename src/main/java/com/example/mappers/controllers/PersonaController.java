package com.example.mappers.controllers;

import com.example.mappers.dtos.PersonaDTO;
import com.example.mappers.entities.Persona;
import com.example.mappers.services.PersonaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/personas")
public class PersonaController extends BaseControllerImpl<Persona, PersonaDTO> {

    @Autowired
    private PersonaServiceImpl service;

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody PersonaDTO entity) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(service.save(entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\": \"Error. Por favor intente mas tarde\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody PersonaDTO entity) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(service.update(id, entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\": \"Error. Por favor intente mas tarde\"}");
        }
    }

}
