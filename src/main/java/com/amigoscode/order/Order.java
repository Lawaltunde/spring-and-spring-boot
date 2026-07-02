package com.amigoscode.order;

import java.time.LocalDate;

public class Order {

    private Long id;
    private String description;
    private String status;
    private double totalAmount;
    private String customerEmail;
    private LocalDate orderDate;
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

    // TODO: 14 - Add @JsonProperty("order_date") to the orderDate field
    //  so it appears as "order_date" in the JSON response
    //  Hint: look at how Customer uses @JsonProperty

    // TODO: 15 - Add @JsonIgnore to the internalNotes field
    //  so it is hidden from the JSON response
    //  Hint: look at how Customer uses @JsonIgnore

    // TODO: 16 - Add @JsonFormat(pattern = "dd-MM-yyyy") to the orderDate field
    //  Add @JsonInclude(JsonInclude.Include.NON_NULL) to the class

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getInternalNotes() {
        return internalNotes;
    }

    public void setInternalNotes(String internalNotes) {
        this.internalNotes = internalNotes;
    }

}
