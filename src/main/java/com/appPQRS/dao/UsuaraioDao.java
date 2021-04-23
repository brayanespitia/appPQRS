package com.appPQRS.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appPQRS.entity.Usuario;


@Repository
public interface UsuaraioDao extends CrudRepository<Usuario, Long> {

}
