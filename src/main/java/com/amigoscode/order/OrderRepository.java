package com.amigoscode.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByStatus(String status);

    List<Order> findByCustomerEmail(String email);

    @Query("SELECT o FROM Order o WHERE o.totalAmount > :amount")
    List<Order> findByTotalAmountGreaterThan(@Param("amount") double amount);

}
