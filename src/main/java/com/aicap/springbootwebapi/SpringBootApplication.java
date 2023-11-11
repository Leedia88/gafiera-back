package com.aicap.springbootwebapi;

import com.aicap.springbootwebapi.dao.EventDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

@org.springframework.boot.autoconfigure.SpringBootApplication



public class SpringBootApplication implements CommandLineRunner {

	@Autowired
	EventDao eventDao;

	@CrossOrigin("http://localhost:3000")
	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
	 	return new BCryptPasswordEncoder();
	 }

	@Override
	public void run(String... args) throws Exception {

	}
}
