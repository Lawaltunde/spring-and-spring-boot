package com.amigoscode.order.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class OrderStatusValidator implements ConstraintValidator<ValidOrderStatus, String> {

    private static final List<String> VALID_STATUSES = List.of(
            "PENDING", "SHIPPED", "DELIVERED", "CANCELLED"
    );

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return VALID_STATUSES.contains(value.toUpperCase());
    }

}
