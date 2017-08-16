package com.mmtc.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.mmtc.springboot")
@EnableWebMvc
public class MVCConfiguration extends WebMvcConfigurerAdapter {

	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(dstInterceptor()).addPathPatterns("/**")
//				.excludePathPatterns(new String[] { "/login", "/logout", "/customerWelcome", "/customerRegn",
//						"/customerPassChange" });

		registry.addInterceptor(authenticationInterceptor()).addPathPatterns("/**")
				.excludePathPatterns(new String[] { "/login", "/logout" });

	}

	@Bean
	public AuthenticationInterceptor authenticationInterceptor(){
		 return new AuthenticationInterceptor();
	}
	
}