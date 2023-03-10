package com.example.demo.modelo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Condena {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    private Preso preso;
    @ManyToOne
    private Delito delito;
    @ManyToOne
    private Juez juez;
    private LocalDate fechaInicio;
    private float duracion;
}
