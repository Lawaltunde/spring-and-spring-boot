package com.amigoscode.order.validation;

// TODO: 4 - Create a custom validation annotation @ValidOrderStatus:
//  - @Constraint(validatedBy = OrderStatusValidator.class)
//  - @Target({ElementType.FIELD})
//  - @Retention(RetentionPolicy.RUNTIME)
//  - Add the required attributes: message(), groups(), payload()
//  - Default message: "Status must be one of: PENDING, SHIPPED, DELIVERED, CANCELLED"
//  Then apply @ValidOrderStatus to the status field in CreateOrderRequest
