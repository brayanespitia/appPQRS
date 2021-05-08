package com.appPQRS.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appPQRS.dao.UsuaraioDao;
import com.appPQRS.entity.Usuario;
import com.appPQRS.service.UsuarioService;


@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	public UsuaraioDao usuarioDao;

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Override
	public void save(Usuario usuario) {
		usuarioDao.save(usuario);

	}

	@Override
	public Usuario findOne(Long id) {
		// TODO Auto-generated method stub
		return usuarioDao.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		usuarioDao.deleteById(id);
	}

	@Override
	public Usuario buscarCedula(String identificacion) {
		// TODO Auto-generated method stub
	 return	usuarioDao.findByIdentificacion(identificacion);
		
		
	}
	
	

}
