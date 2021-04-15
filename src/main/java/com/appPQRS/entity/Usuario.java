package com.appPQRS.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String tipoUsuario;
	private String tipoIdentificacion;
	private String municipio;
	private String codigointerno;
	private String identificacion;
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private String telefonoFijo;
	private String celular;
	private String correo;
	private String direccion;
	private String barrio;
	private LocalDate fechaRegistro;

}
