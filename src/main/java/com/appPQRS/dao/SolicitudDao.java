package com.appPQRS.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appPQRS.entity.Solicitud;
import com.appPQRS.entity.Usuario;


@Repository
public interface SolicitudDao extends CrudRepository<Solicitud, Long> {

	
	@Query("SELECT u from Usuario u INNER JOIN Solicitud s ON s.usuario = u.id where s.id=?1")
	public Usuario findUsuarioBySolicitud(Long id);
	
}
