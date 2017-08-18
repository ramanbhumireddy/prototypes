package com.rsessions;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// super.configure(auth);
		auth.inMemoryAuthentication().withUser("raman").password("ramancg").roles("USER").and().withUser("admin")
				.password("admindtdc").roles("USER", "ADMIN");

	}

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//http.csrf().disable();
		//http.anonymous().disable();
		
//		http.authorizeRequests()
//		.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
//		.antMatchers("/dba/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')")
//		.and().formLogin();
		
		http.anonymous().disable()
		.authorizeRequests()
		.antMatchers("/admin/health", "/admin/info").permitAll()
		.antMatchers("/admin/**").hasAnyRole("ADMIN")
		.antMatchers("/amazon/**").hasAnyRole("USER", "ADMIN")
		.anyRequest().authenticated()
		.and().httpBasic()
		.and()
		  .exceptionHandling().accessDeniedPage("/403");
		//formLogin().loginPage("/login").permitAll()
//		 http.authorizeRequests()
//			.antMatchers("/admin/**").hasAnyRole(roles)  //.access("hasRole('ROLE_ADMIN')")
//			.and()
//			  .formLogin().loginPage("/login").failureUrl("/login?error")
//			  .usernameParameter("username").passwordParameter("password")
//			.and()
//			  .logout().logoutSuccessUrl("/login?logout")
//			.and()
//			  .exceptionHandling().accessDeniedPage("/403");
			
	}
	
}
