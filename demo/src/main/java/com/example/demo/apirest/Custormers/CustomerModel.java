package com.example.demo.apirest.Custormers;

// import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.example.demo.apirest.Orders.OrderModel;

@Entity
@Table(name = "customers")
public class CustomerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String name;
    private String last_name;
    private String email;
    private String phone;
    private String address;
    private String password;
    private Boolean status;

    // mappedBy = "customers" → Como se va a escribir o mapear en OrderModel.java
    // fetch = FetchType.LAZY → Se va a cargar unicamente cuando se la pida
    // fetch = FetchType.EAGER → Los elementos ya tiene los elementos cargados
    @OneToMany(mappedBy = "customers", cascade = CascadeType.ALL)
    private Set<OrderModel> orders;
    // private List<OrderModel> orderModel;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
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

}
