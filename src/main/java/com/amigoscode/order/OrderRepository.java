package com.amigoscode.order;

// TODO: 10 - Replace this class with a JpaRepository interface:
//  public interface OrderRepository extends JpaRepository<Order, Long>
//  Delete all the manual List-based code — JPA handles everything
//  Then update OrderService to use JPA methods (findAll, findById, save, deleteById)

// TODO: 11 - Add derived query methods:
//  List<Order> findByStatus(String status);
//  List<Order> findByCustomerEmail(String email);

// TODO: 12 - Add a custom @Query:
//  @Query("SELECT o FROM Order o WHERE o.totalAmount > :amount")
//  List<Order> findByTotalAmountGreaterThan(@Param("amount") double amount);

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
