package com.example.demo.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Juez extends Persona {
	public Juez(String dni, String nombre, String apellidos) {
		super(dni, nombre, apellidos);
	}

	public Juez() {
		super();
	}
}
