package com.example.repositories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Collection;

@SpringBootApplication
public class RepositoriesApplication {

    public static void main(String[] args) {
        SpringApplication.run(RepositoriesApplication.class, args);
    }

    @Bean
    ApplicationRunner runner(CustomerRepository repository) {
        return events -> {
            repository.getCustomersByName("Matt").forEach(System.out::println);
        };
    }

}

interface CustomCustomerRepository {
    Collection<Customer> getCustomersByName(String name);
}

class CustomAuthorRepositoryImpl implements CustomCustomerRepository {

    private final EntityManager entityManager;

    CustomAuthorRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Collection<Customer> getCustomersByName(String name) {
        return this.entityManager
                .createQuery("select c from Customer  c where c.name =? ", Customer.class)
                .setParameter(1, name)
                .getResultList();
    }
}

interface CustomerRepository extends CustomCustomerRepository,
        JpaRepository<Customer, Integer> {
}

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
class Customer {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
}