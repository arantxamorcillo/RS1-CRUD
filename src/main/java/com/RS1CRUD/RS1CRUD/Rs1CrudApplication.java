package com.RS1CRUD.RS1CRUD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Rs1CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(Rs1CrudApplication.class, args);
	}

	@Bean
	List<Person> PersonList(){

		Person person1 = new Person(1,"Ana", 35, "Madrid" );
		System.out.println(person1);

		List<Person> people = new ArrayList<Person>();
		people.add(person1);
		System.out.println(people);
		return people;
}}
