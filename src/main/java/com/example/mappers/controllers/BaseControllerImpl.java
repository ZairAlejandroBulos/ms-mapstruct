package com.example.mappers.controllers;


import com.example.mappers.dtos.BaseDTO;
import com.example.mappers.entities.Base;
import com.example.mappers.services.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public abstract class BaseControllerImpl<E extends Base, D extends BaseDTO>
    implements BaseController<E, Long> {

    @Autowired
    protected BaseServiceImpl<E, D, Long> service;

    @Override
    @GetMapping("")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(service.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\": \"Error. Por favor intente mas tarde\"}");
        }
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> getOneById(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(service.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\": \"Error. Por favor intente mas tarde\"}");
        }
    }
}