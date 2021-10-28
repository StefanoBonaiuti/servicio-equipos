package com.demo.springboot.app.equipos.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.springboot.app.equipos.models.dao.EquipoDao;
import com.demo.springboot.app.equipos.models.entity.Equipo;

@Service
public class EquipoServiceImpl implements IEquipoService {

	@Autowired
	private EquipoDao equipoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Equipo> findAll() {

		return (List<Equipo>) equipoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Equipo findById(Long id) {

		return equipoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Equipo save(Equipo equipo) {

		return equipoDao.save(equipo);
	}

	@Override
	@Transactional
	public void deleteId(Long id) {

		equipoDao.deleteById(id);
	}

}
