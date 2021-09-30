package com.example.repositories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;
import org.springframework.data.r2dbc.core.R2dbcEntityOperations;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

import static org.springframework.data.relational.core.query.Criteria.where;
import static org.springframework.data.relational.core.query.Query.query;

@SpringBootApplication
public class RepositoriesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepositoriesApplication.class, args);
	}

	@Bean
	ApplicationRunner runner(CustomerRepository repository) {
		return events -> {

			repository.getCustomersByName("Matt").subscribe(m -> System.out.println("Matt: " + m));
			repository.getCustomersByName("Josh").subscribe(j -> System.out.println("Josh: " + j));
		};
	}

}

interface CustomCustomerRepository {
	Flux<Customer> getCustomersByName(String name);
}

class CustomCustomerRepositoryImpl implements CustomCustomerRepository {

	private final R2dbcEntityOperations r2dbcEntityOperations;

	CustomCustomerRepositoryImpl(R2dbcEntityOperations r2dbcEntityOperations) {
		this.r2dbcEntityOperations = r2dbcEntityOperations;
	}

	@Override
	public Flux<Customer> getCustomersByName(String name) {
		return this.r2dbcEntityOperations
			.select(query(where("name").is(name)), Customer.class);
	}
}

interface CustomerRepository extends CustomCustomerRepository,
	R2dbcRepository<Customer, Integer> {
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Customer {

	@Id
	private Integer id;
	private String name;
}