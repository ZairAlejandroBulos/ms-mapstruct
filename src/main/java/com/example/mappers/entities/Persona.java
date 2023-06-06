package com.example.mappers.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "persona")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Persona extends Base {

    private String nombre;

    private String apellido;

    @OneToOne
    @JoinColumn(name = "domicilio_id")
    private Domicilio domicilio;
}
