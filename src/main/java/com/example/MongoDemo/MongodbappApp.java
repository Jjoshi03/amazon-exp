package com.example.MongoDemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.MongoDemo")
@EnableMongoRepositories
public class MongodbappApp implements CommandLineRunner {
	
	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(MongodbappApp.class, args);
	}
	public void run(String... args) throws Exception {
		
		Customer c1 = new Customer("51", "PK",null);
		

				
		productRepository.save(c1);

		
		System.out.println("************************");
		
		List<Customer> customers = productRepository.findAll();
		
		for (Customer c : customers) {
			System.out.println(c.toString());
		}

	}

}