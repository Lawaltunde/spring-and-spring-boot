package com.amigoscode.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

// TODO: 9 - Convert this class to a JPA entity:
//  - Add @Entity annotation
//  - Add @Table(name = "orders") — "order" is a reserved SQL keyword
//  - Add @Id and @GeneratedValue(strategy = GenerationType.IDENTITY) to id
//  - Add a no-arg constructor (already exists)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order {

    private Long id;
    private String description;
    private String status;
    private double totalAmount;
    private String customerEmail;

    @JsonProperty("order_date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate orderDate;

    @JsonIgnore
    private String internalNotes;

    public Order() {
    }

    public Order(Long id, String description, String status, double totalAmount,
                 String customerEmail, LocalDate orderDate, String internalNotes) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.totalAmount = totalAmount;
        this.customerEmail = customerEmail;
        this.orderDate = orderDate;
        this.internalNotes = internalNotes;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
    public String getCustomerEmail() { return customerEmail; }
    public void setCustomerEmail(String customerEmail) { this.customerEmail = customerEmail; }
    public LocalDate getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDate orderDate) { this.orderDate = orderDate; }
    public String getInternalNotes() { return internalNotes; }
    public void setInternalNotes(String internalNotes) { this.internalNotes = internalNotes; }

}
