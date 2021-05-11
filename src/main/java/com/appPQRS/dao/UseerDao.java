package com.appPQRS.dao;

import org.springframework.data.repository.CrudRepository;

import com.appPQRS.entity.Useer;

public interface UseerDao extends CrudRepository<Useer, Long> {
	
public Useer findByUsername (String username);

}
