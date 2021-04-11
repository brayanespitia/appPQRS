package com.appPQRS.service;

import java.util.List;

import com.appPQRS.entity.Solicitud;

public interface SolicitudService {

	public List<Solicitud> findAll();

	public void save(Solicitud solicitud);

	public Solicitud findOne(Long id);

	public void delete(Long id);

}
