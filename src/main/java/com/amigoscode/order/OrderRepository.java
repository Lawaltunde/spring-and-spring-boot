package com.amigoscode.order;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class OrderRepository {

    private final ArrayList<Order> orders = new ArrayList<>(List.of(
            new Order(1L, "Laptop", "PENDING", 999.99, "john@mail.com", LocalDate.now(), "rush"),
            new Order(2L, "Phone", "SHIPPED", 199.99, "lawal@gmail.com", LocalDate.now(), "standard"),
            new Order(3L, "Tablet", "DELIVERED", 299.99, "tablet@gmail.com", LocalDate.now(), "standard")
    ));

    private Long nextIndex = 4L;

    public List<Order> findAll() {
        return orders;
    }
    public Optional<Order> findById(Long id) {
        return orders.stream().filter(order -> order.getId().equals(id)).findFirst();
    }

    public List<Order> getOrdersByStatus(String status) {
        return orders.stream().
                filter(order -> order.getStatus().
                        equalsIgnoreCase(status)).toList();
    }

    public Order save(Order order) {
        order.setId(nextIndex++);
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
            existing.setInternalNotes(order.getInternalNotes());
        });
    }

    public boolean deleteById(Long id) {
        return orders.removeIf(order -> order.getId().equals(id));

    }

}
