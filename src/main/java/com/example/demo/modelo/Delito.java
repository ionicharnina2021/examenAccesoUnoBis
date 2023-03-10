package com.example.demo.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Delito {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int duracionMinima;
    private int duracionMaxima;
    
	public Delito(int duracionMinima, int duracionMaxima) {
		super();
		this.duracionMinima = duracionMinima;
		this.duracionMaxima = duracionMaxima;
	}
    
    
}
