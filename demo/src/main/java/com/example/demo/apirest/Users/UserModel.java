package com.example.demo.apirest.Users;

// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.Table;

import javax.persistence.*; // Impota todas la anotaciones de JPA

import com.example.demo.utils.TimestampEntity;

// import com.example.demo.others.DateEntity;
// import com.example.demo.others.Date2;

// public class UserModel extends Date2

@Entity
@Table(name = "users")
public class UserModel extends TimestampEntity {

    @Id // Detecta que private Long id es un ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Se genere automáticamente
    @Column(unique = true, nullable = false) // Es unico y no puede ser null
    private Long id;

    private String name;
    private String email;
    private Integer priority;

    // @Column(columnDefinition = "TIMESTAMP", name = "created_at", nullable =
    // false, updatable = false)
    // mysql way

    // @Column(name = "created_at", insertable = false, updatable = false,
    // columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
    // private LocalDateTime created_at;

    // @Column(name = "updated_at", insertable = false, updatable = false,
    // columnDefinition = "TIMESTAMP on update CURRENT_TIMESTAMP NOT NULL DEFAULT
    // CURRENT_TIMESTAMP")
    // private LocalDateTime updated_at;

    // LocalDateTime createdAt;
    // LocalDateTime udpatedAt;

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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPriority() {
        return this.priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

}
