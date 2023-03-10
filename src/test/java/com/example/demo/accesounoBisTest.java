package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.modelo.Ingreso;
import com.example.demo.modelo.Preso;
import com.example.demo.repositorios.IngresoRepository;
import com.example.demo.repositorios.PresoRepository;
import com.example.demo.services.PresoService;

@SpringBootTest
class accesounoBisTest {
	@Autowired
	PresoService presoService;
	@Autowired
	IngresoRepository ingresoRepository;
	@Autowired
	PresoRepository presoRepository;

	@Test
	void contextLoads() {
		String dNI = "854215411v";
		Preso preso = new Preso(dNI, "pepe", "jacinto", "s");
		assertTrue(presoService.save(preso));
		LocalDate fechaIngreso = LocalDate.of(2000, 1, 1);
		Optional<Preso> findPresoByDNI = presoService.findPresoByDNI(dNI);
		findPresoByDNI.ifPresent((presoA) -> {
			assertTrue(presoService.addIngreso(presoA.getId(), fechaIngreso));
		});
		System.out.println();
	}

	@Test
	void testLista() {
		String dni[] = { "1", "2", "3" };
		String nombre[] = { "lolo", "chencho", "nacho" };
		String apellidos[] = { "geranio", "gladiolo", "gardenio" };
		String condicion[] = { "c", "l", "e" };
		for (int i = 0; i < dni.length; i++) {
			presoService.save(new Preso(dni[i],nombre[i],apellidos[i],condicion[i]));
		}
		LocalDate fechasIngreso[] = { LocalDate.of(2000, 1, 1), LocalDate.of(2001, 1, 1), LocalDate.of(2001, 1, 1),
				LocalDate.of(2003, 1, 1) };
		for (int i = 1; i < fechasIngreso.length - 1; i++) {
			LocalDate fecha=fechasIngreso[i];
			Preso preso = presoService.findPresoByDNI(dni[i]).get();
			Ingreso ingreso=new Ingreso(fecha,preso);
			ingresoRepository.save(ingreso);
			presoService.addIngreso(preso,ingreso);
		}
		presoService.addIngreso(dni[0], fechasIngreso[fechasIngreso.length - 1]);
		List<Ingreso> ingresoByFecha = presoService.getIngresoByFecha(fechasIngreso[1]);
		List<Preso> presosByFecha = presoService.getPresosByFecha(fechasIngreso[1]);
		System.out.println();
	}

}
