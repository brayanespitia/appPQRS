package com.appPQRS.service;

import java.util.List;


import com.appPQRS.entity.Usuario;

public interface UsuarioService {
	
	public List<Usuario> findAll();

	public void save(Usuario usuario);

	public Usuario findOne(Long id);

	public void delete(Long id);
	
public Usuario buscarCedula(String identificacion);

}
