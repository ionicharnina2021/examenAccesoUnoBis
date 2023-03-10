package com.example.demo.repositorios;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.modelo.Ingreso;

public interface IngresoRepository extends CrudRepository<Ingreso, Long> {
	public List<Ingreso> findByFecha(LocalDate fecha);
	
}
