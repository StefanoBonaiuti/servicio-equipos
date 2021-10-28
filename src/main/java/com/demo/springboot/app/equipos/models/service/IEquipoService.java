package com.demo.springboot.app.equipos.models.service;

import java.util.List;

import com.demo.springboot.app.equipos.models.entity.Equipo;

public interface IEquipoService {

	public List<Equipo> findAll();

	public Equipo findById(Long id);

	public Equipo save(Equipo equipo);

	public void deleteId(Long id);

}
