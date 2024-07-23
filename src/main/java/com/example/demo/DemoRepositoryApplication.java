package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class DemoRepositoryApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(DemoRepositoryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		repository.deleteAll();

		//save some customers
		repository.save(new Customer("Alice", "Application"));
		repository.save(new Customer("Carl", "Database"));

		//get all customers
		System.out.println("Customers with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : repository.findAll()){
			System.out.println(customer);
		}
		System.out.println();
	}

}
