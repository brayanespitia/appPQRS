package com.appPQRS.service;

import java.util.List;

import com.appPQRS.entity.Funcionario;

public interface FuncionarioService {
	
	
	public List<Funcionario> listAll();
	
	public void save (Funcionario funcionario);
	
	public void delete (long id);
	
	public Funcionario finOne(Long id);

}
