package com.demo.springboot.app.equipos.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CapacidadEstadioValidacion.class)
public @interface CapacidadEstadio {
	
	String message() default "Debe introducir una capacidad basada en la division del equipo";
	Class<?>[] groups() default {};
	public abstract Class<? extends Payload>[] payload() default {};

}
