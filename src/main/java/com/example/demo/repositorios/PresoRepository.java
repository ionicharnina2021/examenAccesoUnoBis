package com.example.demo.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.modelo.Preso;

public interface PresoRepository extends CrudRepository<Preso, Long> {
	public Preso findByDni(String Dni);
}
