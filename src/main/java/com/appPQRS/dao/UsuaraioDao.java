package com.appPQRS.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appPQRS.entity.Usuario;


@Repository
public interface UsuaraioDao extends CrudRepository<Usuario, Long> {
	
//@Query("SELECT u FROM Usuario u WHERE u.identificacion =?1")
public Usuario findByIdentificacion(String identificacion);

}
