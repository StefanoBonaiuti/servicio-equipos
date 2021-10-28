package com.demo.springboot.app.equipos.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.demo.springboot.app.equipos.validation.CapacidadEstadio;

@CapacidadEstadio()
@Entity
@Table(name = "EQUIPOS")
public class Equipo implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(min=3,max=20, message = "El nombre del equipo debe tener al menos entre 3 y 20 caracteres")
	private String nombre;
	
	@NotBlank
	@Size(min=3,max=20,message = "El nombre de la ciudad debe tener al menos entre 3 y 20 caracteres")
	private String ciudad;
	
	@NotBlank
	@Size(min=3,max=20,message = "El nombre del propietario debe tener al menos entre 3 y 20 caracteres")
	private String propietario;

	@Positive(message = "El numero de la capacidad tiene que ser positivo")
	@Column(name = "capacidad_estadio")
	private int capacidadEstadio;

	@Min(1)
	@Max(3)
	private int division;

	@NotBlank(message = "Debe introducir el nombre de la competicion")
	@Size(min=3,max=20, message = "El nombre de la competicion debe tener al menos entre 3 y 20 caracteres")
	private String competicion;

	@Min(11)
	@Column(name = "numero_jugadores")
	private int numeroJugadores;

	@Past
	@Column(name = "fecha_creacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;

	public Equipo() {
		super();
	}

	public Equipo(String nombre, String ciudad, String propietario, int capacidadEstadio, int division,
			String competicion, int numeroJugadores, Date fechaCreacion) {
		super();
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.propietario = propietario;
		this.capacidadEstadio = capacidadEstadio;
		this.division = division;
		this.competicion = competicion;
		this.numeroJugadores = numeroJugadores;
		this.fechaCreacion = fechaCreacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public int getCapacidadEstadio() {
		return capacidadEstadio;
	}

	public void setCapacidadEstadio(int capacidadEstadio) {
		this.capacidadEstadio = capacidadEstadio;
	}

	public int getDivision() {
		return division;
	}

	public void setDivision(int division) {
		this.division = division;
	}

	public String getCompeticion() {
		return competicion;
	}

	public void setCompeticion(String competicion) {
		this.competicion = competicion;
	}

	public int getNumeroJugadores() {
		return numeroJugadores;
	}

	public void setNumeroJugadores(int numeroJugadores) {
		this.numeroJugadores = numeroJugadores;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Override
	public String toString() {
		return "Equipo [id=" + id + ", nombre=" + nombre + ", ciudad=" + ciudad + ", propietario=" + propietario
				+ ", capacidadEstadio=" + capacidadEstadio + ", division=" + division + ", competicion=" + competicion
				+ ", numeroJugadores=" + numeroJugadores + ", fechaCreacion=" + fechaCreacion + "]";
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4037005920526968634L;

}
