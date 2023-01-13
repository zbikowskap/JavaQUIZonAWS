package com.zbikpQuiz.main;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@SpringBootApplication
public class JavaQuizApp implements CommandLineRunner {

	//I implements CommandLineRunner to push auto CREATE TABLE hibernate, then FLYWAY init
	//without override first run flyway and fail without table
	@Autowired
	DataSource dataSource;



	public static void main(String[] args) {
		SpringApplication.run(JavaQuizApp.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		Flyway.configure().baselineOnMigrate(true).dataSource(dataSource).load().migrate();
	}

}
