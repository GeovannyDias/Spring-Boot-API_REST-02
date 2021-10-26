package com.example.demo.apirest.Orders;

import javax.persistence.*;

import com.example.demo.apirest.Custormers.CustomerModel;

@Entity
@Table(name = "orders")
public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String name_item;
    private String description;
    private String price;
    private Boolean status;

    // fetch = FetchType.LAZY → Se va a cargar unicamente cuando se la pida
    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id", nullable = false, referencedColumnName = "id")
    private CustomerModel customers;

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

    public CustomerModel getCustomers() {
        return this.customers;
    }

    public void setCustomers(CustomerModel customers) {
        this.customers = customers;
    }

}
