package com.example.functions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FunctionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FunctionsApplication.class, args);
	}

	@Bean
	public Function<Person, Employee> hire() {
		return person -> {
			Employee employee = new Employee(person);
			return employee;
		};
	}

}

class Employee {

	private Person person;

	private int id;

	public Employee() {
	}

	public Employee(Person person) {
		this.person = person;
		this.id = new Random().nextInt(1000);
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return "Employee " + id + " was hired on " + new SimpleDateFormat("dd-MM-yyyy").format(new Date());
	}
}

class Person {

	private String firstName;

	private String lastName;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
}