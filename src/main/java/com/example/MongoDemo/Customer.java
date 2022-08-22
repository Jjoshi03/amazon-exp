package com.example.MongoDemo;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("customers")
@Getter @Setter @NoArgsConstructor // <--- THIS is it
public class Customer  implements Serializable {
	
	@Id
	public String id;
	public String name;
	public String lastname;
	
		
	public Customer(String id, String name, String lastname) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
	}




}