package com.appPQRS.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appPQRS.entity.Solicitud;


@Repository
public interface SolicitudDao extends CrudRepository<Solicitud, Long> {

}
