package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;

@SpringBootApplication
public class DemoApplication {


	ResponseEntity<Customer> readCustomer() {
		return ResponseEntity.notFound().build();
	}

	ResponseEntity<String> readString() {
		return ResponseEntity.notFound().build();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	ApplicationRunner runner() {
		return args -> {
			var obj = Customer.class.getConstructors()[0].newInstance(1, "Dilip");
			System.out.println("the new object is "   + obj);
		};
	}

}


@Data
@AllArgsConstructor
@NoArgsConstructor
class Customer {
	private Integer id;
	private String name;

}