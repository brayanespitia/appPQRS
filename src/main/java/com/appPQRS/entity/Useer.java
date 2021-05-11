package com.appPQRS.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class Useer  implements Serializable{

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 30, unique = true)
	private String username;

	@Column(length = 60)
	private String password;

	private Boolean enabled;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private List<Rol> roles;

	
	private String identificacion;
	private String codigo;
	private String nombreCompelto;
	private String correo;
	private String esAdmin;
	private Date fehcaRegistro;
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public Boolean getEnabled() {
		return enabled;
	}




	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}




	public List<Rol> getRoles() {
		return roles;
	}




	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}




	public String getIdentificacion() {
		return identificacion;
	}




	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}




	public String getCodigo() {
		return codigo;
	}




	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}




	public String getNombreCompelto() {
		return nombreCompelto;
	}




	public void setNombreCompelto(String nombreCompelto) {
		this.nombreCompelto = nombreCompelto;
	}




	public String getCorreo() {
		return correo;
	}




	public void setCorreo(String correo) {
		this.correo = correo;
	}




	public String getEsAdmin() {
		return esAdmin;
	}




	public void setEsAdmin(String esAdmin) {
		this.esAdmin = esAdmin;
	}




	public Date getFehcaRegistro() {
		return fehcaRegistro;
	}




	public void setFehcaRegistro(Date fehcaRegistro) {
		this.fehcaRegistro = fehcaRegistro;
	}

}
