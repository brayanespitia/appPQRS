package com.appPQRS.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
