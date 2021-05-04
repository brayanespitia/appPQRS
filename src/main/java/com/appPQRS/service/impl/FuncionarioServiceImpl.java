package com.appPQRS.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appPQRS.dao.FuncionarioDao;
import com.appPQRS.entity.Funcionario;
import com.appPQRS.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {
	
	
	
	@Autowired
	public FuncionarioDao funcionarioDao;

	@Override
	public List<Funcionario> listAll() {
		// TODO Auto-generated method stub
		return (List<Funcionario>) funcionarioDao.findAll(); 
	}

	@Override
	public void save(Funcionario funcionario) {
		// TODO Auto-generated method stub
		funcionarioDao.save(funcionario);

	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		funcionarioDao.deleteById(id);

	}

	@Override
	public Funcionario finOne(Long id) {
		// TODO Auto-generated method stub
		return funcionarioDao.findById(id).get();
	}

}
