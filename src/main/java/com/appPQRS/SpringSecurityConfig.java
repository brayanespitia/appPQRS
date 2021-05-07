package com.appPQRS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;




@Configuration
public class SpringSecurityConfig  extends WebSecurityConfigurerAdapter {

@Bean
public BCryptPasswordEncoder passwordEncoder() {
	
	return new BCryptPasswordEncoder();
}
	

@Override
protected void configure(HttpSecurity http) throws Exception {
	// TODO Auto-generated method stub
	http.authorizeRequests().antMatchers("/","/css/**","/js/**","/bootstrap/**","/registrarUsuario","/solicitud/consultar","/funcionario/loge").permitAll()
	.antMatchers("/solicitud/registrar").hasAnyRole("ADMIN")
	
	.anyRequest().authenticated()
	.and()
	.formLogin()
	.defaultSuccessUrl("/funcionario/loge")
	 .loginPage("/funcionario/log")
	.permitAll()
	.and()
	.logout().permitAll()
	;
}


	
	@Autowired
	public void configuredGlobal(AuthenticationManagerBuilder builder) throws Exception {
		
         
		
		PasswordEncoder encoder = passwordEncoder();
		UserBuilder users = User.builder().passwordEncoder(encoder :: encode);
		builder.inMemoryAuthentication()
		.withUser(users.username("admin").password("12345").roles("ADMIN", "USER"))
		.withUser(users.username("brayan").password("12345").roles("USER"))
		
		;

	
		
		
	
	}





	

	
	

}
