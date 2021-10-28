package com.demo.springboot.app.equipos.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.demo.springboot.app.equipos.models.entity.Equipo;

public class CapacidadEstadioValidacion implements ConstraintValidator<CapacidadEstadio, Equipo> {

	@Override
	public boolean isValid(Equipo equipo, ConstraintValidatorContext context) {
		
		if(equipo.getDivision() == 1 && equipo.getCapacidadEstadio() > 50000) {
			
			return true;
		}else if(equipo.getDivision() == 2 && equipo.getCapacidadEstadio() > 10000) {
			
			return true;
		}else if(equipo.getDivision() == 3 && equipo.getCapacidadEstadio() > 3000) {
			
			return true;
		}
		
		return false;
	}
	
	@Override
	public void initialize(CapacidadEstadio contraintAnnotation) {
		
	}

}
