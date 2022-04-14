package com.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Main implementation class which serves two purpose in a spring boot application: Configuration and bootstrapping.
 * @author ibtesam malik
 */
@SpringBootApplication
public class Myapplication extends SpringBootServletInitializer{

	
	
	  public static void main(String[] args) {
	  SpringApplication.run(Myapplication.class, args); }
	  
}