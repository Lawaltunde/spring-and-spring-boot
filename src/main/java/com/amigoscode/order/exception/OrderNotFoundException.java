package com.amigoscode.order.exception;

// TODO: 5 - Create this exception class:
//  - Extend RuntimeException
//  - Add @ResponseStatus(HttpStatus.NOT_FOUND) annotation
//  - Add a constructor that takes a Long id and passes "Order not found with id: " + id to super()
//  Then go to OrderService and throw this exception in getOrderById when not found
public class OrderNotFoundException {

}
