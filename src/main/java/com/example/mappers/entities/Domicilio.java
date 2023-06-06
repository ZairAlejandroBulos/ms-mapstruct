package com.example.mappers.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "domicilio")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Domicilio extends Base {

    private String calle;
    private Integer numero;

}
