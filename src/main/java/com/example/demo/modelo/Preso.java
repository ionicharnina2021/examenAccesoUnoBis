package com.example.demo.modelo;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Preso extends Persona {
	
	private String estado;
	@OneToMany(mappedBy = "preso",fetch = FetchType.EAGER)
	private List<Ingreso> ingresos=new ArrayList();

	public Preso(String dni, String nombre, String apellidos, String estado) {
		super(dni, nombre, apellidos);
		this.estado = estado;
	}

	public Preso() {
		super();
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<Ingreso> getIngresos() {
		return ingresos;
	}

	public void addIngreso(Ingreso ingreso) {
		ingresos.add(ingreso);
		
	}

}
