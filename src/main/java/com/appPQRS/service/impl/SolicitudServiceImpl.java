package com.appPQRS.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appPQRS.dao.SolicitudDao;
import com.appPQRS.dao.UsuaraioDao;
import com.appPQRS.entity.Solicitud;
import com.appPQRS.entity.Usuario;
import com.appPQRS.service.SolicitudService;


@Service
public class SolicitudServiceImpl implements SolicitudService {
	
	
	@Autowired
	public UsuaraioDao usuarioDao;
	
	@Autowired
	public SolicitudDao solicitudDao;
	

	@Override
	public List<Solicitud> findAll() {
		// TODO Auto-generated method stub
		return (List<Solicitud>) solicitudDao.findAll();
	}

	@Override
	@Transactional
	public void save(Solicitud solicitud) {
		// TODO Auto-generated method stub
		//String cedula= solicitud.getUsuario().getIdentificacion();
	
		
		//Usuario usuario = usuarioDao.findByIdentificacion(cedula);
		//solicitud.setUsuario(usuario);
		solicitudDao.save(solicitud);

	}

	@Override
	public Solicitud findOne(Long id) {
		// TODO Auto-generated method stub
		return solicitudDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
solicitudDao.deleteById(id);
	}

	@Override
	public Usuario findUsuarioBySolicitud(Long id) {
		// TODO Auto-generated method stub
		
		
		return solicitudDao.findUsuarioBySolicitud(id);
	}

}
