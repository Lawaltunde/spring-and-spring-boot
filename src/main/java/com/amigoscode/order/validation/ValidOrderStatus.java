package com.amigoscode.order.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = OrderStatusValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidOrderStatus {
    String message() default "Status must be one of: PENDING, SHIPPED, DELIVERED, CANCELLED";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
