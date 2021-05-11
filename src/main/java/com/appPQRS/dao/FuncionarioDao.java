package com.appPQRS.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appPQRS.entity.Funcionario;


@Repository
public interface FuncionarioDao  extends CrudRepository<Funcionario, Long>{
	
	public Funcionario findByidentificacion(String identificacion);

}
