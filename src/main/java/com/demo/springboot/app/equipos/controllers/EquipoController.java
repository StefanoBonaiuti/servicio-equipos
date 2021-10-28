package com.demo.springboot.app.equipos.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springboot.app.equipos.models.entity.Equipo;
import com.demo.springboot.app.equipos.models.service.IEquipoService;

@RestController
public class EquipoController {

	@Autowired
	private IEquipoService iEquipoService;

	@GetMapping("/listar")
	public List<Equipo> listar() {
		return iEquipoService.findAll();
	}

	@GetMapping("/listar/{id}")
	public Equipo detalle(@PathVariable Long id) {
		return iEquipoService.findById(id);
	}
	
	@GetMapping("/lista/ordenada")
	public List<Equipo> listarOrdenadamente() {
		
		List<Equipo> listaOrdenada = new ArrayList<>();
		listaOrdenada = iEquipoService.findAll();
		listaOrdenada.sort(Comparator.comparing(Equipo::getCapacidadEstadio));
		
		return listaOrdenada;
	}

	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Equipo crear(@Valid @RequestBody Equipo equipo) {

		return iEquipoService.save(equipo);
	}

	@PutMapping("/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Equipo editar(@Valid @RequestBody Equipo equipo, @PathVariable Long id) {

		Equipo equipoDb = iEquipoService.findById(id);

		System.out.println(equipoDb.toString());
		
		equipoDb.setNombre(equipo.getNombre());
		equipoDb.setCiudad(equipo.getCiudad());
		equipoDb.setPropietario(equipo.getPropietario());
		equipoDb.setCapacidadEstadio(equipo.getCapacidadEstadio());
		equipoDb.setDivision(equipo.getDivision());
		equipoDb.setCompeticion(equipo.getCompeticion());
		equipoDb.setNumeroJugadores(equipo.getNumeroJugadores());

		return iEquipoService.save(equipoDb);
	}

	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Long id) {

		iEquipoService.deleteId(id);
	}

}
