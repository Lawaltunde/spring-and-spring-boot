package com.amigoscode.order;

import java.util.List;
import java.util.Optional;

// TODO: 12 - Create the OrderRepository class:
//  - Annotate with @Repository
//  - Add a private List<Order> field initialized with sample orders (use ArrayList)
//  - Add a private long nextId field starting at 4
//  - Implement these methods:
//    List<Order> findAll()
//    Optional<Order> findById(Long id)
//    List<Order> findByStatus(String status)
//    Order save(Order order) — sets the id and adds to the list
//    void update(Order order) — finds by id and updates fields
//    boolean deleteById(Long id) — removes from list
//  Hint: look at CustomerRepository for reference
