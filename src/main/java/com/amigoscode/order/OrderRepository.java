package com.amigoscode.order;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository {

    private final List<Order> orders = new ArrayList<>(List.of(
            new Order(1L, "Laptop", "PENDING", 999.99, "john@mail.com", LocalDate.now(), "rush"),
            new Order(2L, "Phone", "SHIPPED", 599.99, "jane@mail.com", LocalDate.now().minusDays(2), "fragile"),
            new Order(3L, "Tablet", "DELIVERED", 399.99, "bob@mail.com", LocalDate.now().minusDays(5), "none")
    ));

    private long nextId = 4L;

    public List<Order> findAll() {
        return orders;
    }

    public Optional<Order> findById(Long id) {
        return orders.stream()
                .filter(o -> o.getId().equals(id))
                .findFirst();
    }

    public List<Order> findByStatus(String status) {
        return orders.stream()
                .filter(o -> o.getStatus().equalsIgnoreCase(status))
                .toList();
    }

    public Order save(Order order) {
        order.setId(nextId++);
        orders.add(order);
        return order;
    }

    public void update(Order order) {
        findById(order.getId()).ifPresent(existing -> {
            existing.setDescription(order.getDescription());
            existing.setStatus(order.getStatus());
            existing.setTotalAmount(order.getTotalAmount());
            existing.setCustomerEmail(order.getCustomerEmail());
            existing.setOrderDate(order.getOrderDate());
        });
    }

    public boolean deleteById(Long id) {
        return orders.removeIf(o -> o.getId().equals(id));
    }

}
