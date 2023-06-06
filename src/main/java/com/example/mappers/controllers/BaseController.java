package com.example.mappers.controllers;

import com.example.mappers.entities.Base;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.Serializable;

public interface BaseController<E extends Base, ID extends Serializable> {

    ResponseEntity<?> getAll();
    ResponseEntity<?> getOneById(@PathVariable ID id);

}
