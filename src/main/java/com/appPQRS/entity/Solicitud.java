package com.appPQRS.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Solicitud {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String motivoSolicitud;
	private String funcionario;
	private String usuario;
	private String otroMotivo;
	private String descripcion;
	private String respuesta;
	private Boolean respodida;
	private Date fechaRegistro;
	private Date fechaRespuesta;
	
	
	
	public Solicitud() {
		
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getMotivoSolicitud() {
		return motivoSolicitud;
	}



	public void setMotivoSolicitud(String motivoSolicitud) {
		this.motivoSolicitud = motivoSolicitud;
	}



	public String getFuncionario() {
		return funcionario;
	}



	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}



	public String getUsuario() {
		return usuario;
	}



	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}



	public String getOtroMotivo() {
		return otroMotivo;
	}



	public void setOtroMotivo(String otroMotivo) {
		this.otroMotivo = otroMotivo;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public String getRespuesta() {
		return respuesta;
	}



	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}



	public Boolean getRespodida() {
		return respodida;
	}



	public void setRespodida(Boolean respodida) {
		this.respodida = respodida;
	}



	public Date getFechaRegistro() {
		return fechaRegistro;
	}



	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}



	public Date getFechaRespuesta() {
		return fechaRespuesta;
	}



	public void setFechaRespuesta(Date fechaRespuesta) {
		this.fechaRespuesta = fechaRespuesta;
	}
	
	
	


}
