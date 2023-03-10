package com.example.demo.services;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.swing.LookAndFeel;

import org.springframework.stereotype.Service;

import com.example.demo.modelo.Ingreso;
import com.example.demo.modelo.Preso;
import com.example.demo.repositorios.IngresoRepository;
import com.example.demo.repositorios.PresoRepository;

@Service
public class PresoService {
	private final IngresoRepository ingresoRepository;
	private final PresoRepository presoRepository;

	public PresoService(IngresoRepository ingresoRepository, PresoRepository presoRepository) {
		super();
		this.ingresoRepository = ingresoRepository;
		this.presoRepository = presoRepository;
	}

	public Optional<List<Preso>> getAll() {
		return new Iterable2ListMapper<Preso>().map(presoRepository.findAll());
	}

	public boolean save(Preso preso) {
		return this.presoRepository.save(preso) != null;
	}

	public boolean addIngreso(Long idPreso, LocalDate fechaIngreso) {
		return presoRepository.findById(idPreso).map((preso) -> {
			Ingreso ingreso = new Ingreso(fechaIngreso, preso);
			preso.addIngreso(ingreso);
			ingresoRepository.save(ingreso);
			return true;
		}).orElse(false);
	}

	public boolean addIngreso(String dni, LocalDate fechaIngreso) {
		return addIngreso(findPresoByDNI(dni).get().getId(), fechaIngreso);
	}

	public Optional<Preso> findPreso(Long idPreso) {
		return presoRepository.findById(idPreso);
	}

	public Optional<Preso> findPresoByDNI(String DNI) {
		return Optional.of(presoRepository.findByDni(DNI));
	}
	
	public List<Ingreso> getIngresoByFecha(LocalDate fecha) {
		return ingresoRepository.findByFecha(fecha);
	}

	public List<Preso> getPresosByFecha(LocalDate fecha) {
		return ingresoRepository.findByFecha(fecha)
				.stream().map((ingreso)->{return ingreso.getPreso();}).toList();
	}

	public void addIngreso(Preso preso, Ingreso ingreso) {
		preso.addIngreso(ingreso);
		
	}
}
