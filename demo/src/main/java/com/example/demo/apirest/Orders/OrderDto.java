package com.example.demo.apirest.Orders;

public class OrderDto {
    private Long id;
    private String name_item;
    private String description;
    private String price;
    private Boolean status;
    private Long customer_id;

    // Default Contructor
    public OrderDto() {
    }

    // public OrderDto(String name_item, String description, String price, Boolean
    // status, Long customer_id) {
    // super();
    // this.name_item = name_item;
    // this.description = description;
    // this.price = price;
    // this.status = status;
    // this.customer_id = customer_id;
    // }

    // Entity to DTO
    public OrderDto(OrderModel order) {
        super();
        this.name_item = order.getName_item();
        this.description = order.getDescription();
        this.price = order.getPrice();
        this.status = order.getStatus();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName_item() {
        return this.name_item;
    }

    public void setName_item(String name_item) {
        this.name_item = name_item;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Boolean isStatus() {
        return this.status;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Long getCustomer_id() {
        return this.customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

}
