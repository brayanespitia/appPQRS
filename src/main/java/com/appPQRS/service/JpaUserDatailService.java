package com.appPQRS.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.ILoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.appPQRS.dao.UseerDao;

import com.appPQRS.entity.Useer;
import com.appPQRS.entity.Rol;


@Service("jpaUserDetailsService")
public class JpaUserDatailService implements UserDetailsService {
	
	
	@Autowired
	private UseerDao useerDao;

	private Logger logger = LoggerFactory.getLogger(JpaUserDatailService.class);
	
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
	Useer usuario = useerDao.findByUsername(username);
		

	if (usuario == null) {
		
		logger.error("Error login: no existe el usuario" + username+ " ''");
		
	
		
		throw new UsernameNotFoundException("Username" + username + " No existe en el sitema");
		
	}
	List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	
	for(Rol role: usuario.getRoles()) {
		logger.info("ROLE"  + role.getAuthority());
		
		authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
		
	}
	if (authorities.isEmpty()) {
		
		logger.error("Error login: no existe el usuario" + username+ " nopm tiene roles asignados''");
		throw new UsernameNotFoundException("Error login: no existe el usuario" + username + " nopm tiene roles asignados''");
	}
	
	
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true, authorities);
	}

}
