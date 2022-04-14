package com.jwt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class Securityconfig extends WebSecurityConfigurerAdapter {

	 @Autowired
	 private MyBasicAuthenticationEntryPoint authenticationEntryPoint;
	 
	@Bean
	public Jwtauthfilter jwtAuthenticationFilter() {
		return new Jwtauthfilter();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/mcib/connect/token")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.csrf().disable()
		.addFilterBefore(jwtAuthenticationFilter(), 
				UsernamePasswordAuthenticationFilter.class);
		
		http.authorizeRequests()
        .antMatchers("/mcib/connect/introspect").permitAll()
        .anyRequest().authenticated()
        .and()
        .httpBasic()
        .authenticationEntryPoint(authenticationEntryPoint);
		
		
		http.authorizeRequests()
        .antMatchers("/api/dealers/mcib/edi").permitAll()
        .anyRequest().authenticated();

      http.addFilterAfter(new CustomFilter(),
        BasicAuthenticationFilter.class);
	}
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) 
      throws Exception {
        auth.inMemoryAuthentication().withUser(Iconstants.INTROSECPTION_USERNAME)
          .password(passwordEncoder().encode(Iconstants.INTROSECPTION_PASSWORD)).roles("USER", "ADMIN");
    }
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
}