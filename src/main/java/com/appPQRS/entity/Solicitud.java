package com.appPQRS.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

@Entity
public class Solicitud implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String motivoSolicitud;
	private String funcionario;
	
	private String tipoSolicitud;
	private String descripcion;
	private String respuesta;
	private Boolean respodida;
	private Date fechaRegistro;
	private Date fechaRespuesta;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario usuario;
	
	
	
	@PrePersist
	public void prePersist() {
		fechaRegistro = new Date();
	}
	
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



	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getTipoSolicitud() {
		return tipoSolicitud;
	}

	public void setTipoSolicitud(String tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}
	
	
	


}
