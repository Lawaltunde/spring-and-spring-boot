package com.amigoscode.order;

import com.amigoscode.order.exception.OrderNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderService.class);

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        log.info("Fetching all orders");
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        log.info("Fetching order with id: {}", id);
        return orderRepository.findById(id)
                .orElseThrow(() -> {
                    log.warn("Order not found with id: {}", id);
                    return new OrderNotFoundException(id);
                });
    }

    public List<Order> getOrdersByStatus(String status) {
        log.info("Fetching orders with status: {}", status);
        return orderRepository.findByStatus(status);
    }

    public Order createOrder(Order order) {
        log.info("Creating order: {}", order.getDescription());
        return orderRepository.save(order);
    }

    public void updateOrder(Order order) {
        log.info("Updating order with id: {}", order.getId());
        orderRepository.save(order);
    }

    public boolean deleteOrder(Long id) {
        log.info("Deleting order with id: {}", id);
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return true;
        }
        log.warn("Cannot delete - order not found with id: {}", id);
        return false;
    }

}
