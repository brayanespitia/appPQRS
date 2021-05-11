package com.appPQRS;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.appPQRS.service.JpaUserDatailService;
import com.appPQRS.service.impl.FuncionarioServiceImpl;




@Configuration
public class SpringSecurityConfig  extends WebSecurityConfigurerAdapter {



@Autowired
private JpaUserDatailService userDetailService;



@Autowired
private BCryptPasswordEncoder passwordEncoder;

@Autowired
public void configuredGlobal(AuthenticationManagerBuilder build) throws Exception {
	
     
	build.userDetailsService(userDetailService)
	.passwordEncoder(passwordEncoder)
	
	;

}


@Override
protected void configure(HttpSecurity http) throws Exception {
	// TODO Auto-generated method stub
	http.authorizeRequests().antMatchers("/","/css/**","/js/**","/bootstrap/**","/registrarUsuario","/solicitud/consultar","/funcionario/loge", "/solicitud/**", "/solicitud/detalle/**", "/funcionario/**", "/login").permitAll()
		
	.anyRequest().authenticated()
	.and()
	.formLogin()
	.defaultSuccessUrl("/funcionario/loge")
	 .loginPage("/login")
	.permitAll()
	.and()
	.logout().permitAll()
	;
}


	






	

	
	

}
