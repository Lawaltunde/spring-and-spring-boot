package com.amigoscode.order.dto;

import com.amigoscode.order.validation.ValidOrderStatus;
import jakarta.validation.constraints.*;

public class CreateOrderRequest {

    @NotBlank(message = "Description is required")
    @Size(min = 5, max = 200, message = "Description must be between 5 and 200 characters")
    private String description;

    @ValidOrderStatus
    private String status;

    @NotNull(message = "Total amount is required")
    @Positive(message = "Total amount must be positive")
    private Double totalAmount;

    @NotBlank(message = "Customer email is required")
    @Email(message = "Customer email must be valid")
    private String customerEmail;

    public CreateOrderRequest() {
    }

    public CreateOrderRequest(String description, String status,
                              Double totalAmount, String customerEmail) {
        this.description = description;
        this.status = status;
        this.totalAmount = totalAmount;
        this.customerEmail = customerEmail;
    }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(Double totalAmount) { this.totalAmount = totalAmount; }
    public String getCustomerEmail() { return customerEmail; }
    public void setCustomerEmail(String customerEmail) { this.customerEmail = customerEmail; }

}
