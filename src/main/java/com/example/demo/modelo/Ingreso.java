package com.example.demo.modelo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Ingreso {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private LocalDate fecha;
	@ManyToOne
	private Preso preso;
	
	public Ingreso(LocalDate fecha, Preso preso) {
		super();
		this.fecha = fecha;
		this.preso = preso;
	}
	
	public Ingreso() {
		super();
	}

	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Preso getPreso() {
		return preso;
	}
	public void setPreso(Preso preso) {
		this.preso = preso;
	}
	public Long getId() {
		return id;
	}
	
	
	
}
