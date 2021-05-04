package com.appPQRS.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.appPQRS.dao.FuncionarioDao;
import com.appPQRS.entity.Funcionario;

@Service
public class JpaUserDatailService implements UserDetailsService {
	
	
	@Autowired
	private FuncionarioDao funcionarioDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
	//	Funcionario funcionario = funcionarioDao.findByUsername(username);
		
		return null;
	}

}
