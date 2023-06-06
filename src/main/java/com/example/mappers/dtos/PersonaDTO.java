package com.example.mappers.dtos;

import lombok.Data;

@Data
public class PersonaDTO extends BaseDTO {

    private String nombre;
    private String apellido;
    private DomicilioDTO domicilio;
}
