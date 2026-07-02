package com.amigoscode.customer;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepository {

    private final List<Customer> customers = new ArrayList<>(List.of(
            new Customer(1L, "Alice", "alice@mail.com", "INT-001"),
            new Customer(2L, "Bob", "bob@mail.com", "INT-002"),
            new Customer(3L, "Charlie", "charlie@mail.com", "INT-003")
    ));

    private long nextId = 4L;

    public List<Customer> findAll() {
        return customers;
    }

    public Optional<Customer> findById(Long id) {
        return customers.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }

    public Customer save(Customer customer) {
        customer.setId(nextId++);
        customers.add(customer);
        return customer;
    }

    public void update(Customer customer) {
        findById(customer.getId()).ifPresent(existing -> {
            existing.setName(customer.getName());
            existing.setEmail(customer.getEmail());
        });
    }

    public boolean deleteById(Long id) {
        return customers.removeIf(c -> c.getId().equals(id));
    }

}
