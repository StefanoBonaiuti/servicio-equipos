package com.demo.springboot.app.equipos.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.springboot.app.equipos.models.entity.Equipo;

@Repository
public interface EquipoDao extends CrudRepository<Equipo, Long> {

}
