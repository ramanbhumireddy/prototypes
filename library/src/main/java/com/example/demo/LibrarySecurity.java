package com.example.demo;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class LibrarySecurity extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/las/**").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/lus/**").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
		.and()
		//.formLogin();
		.httpBasic();

	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("raman").password("raman").authorities("ROLE_USER")
		.and()
		.withUser("admin").password("admin").authorities("ROLE_USER","ROLE_ADMIN");
	}

}
