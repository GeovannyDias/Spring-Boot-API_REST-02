package com.example.demo.utils;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class TimestampEntity {
    // @Column(columnDefinition = "TIMESTAMP", name = "created_at", nullable =
    // false, updatable = false)
    // @Column(name = "createdAt", nullable = false, updatable = false)

    // @CreatedDate
    // @Column(name = "created_at", nullable = false, updatable = false)
    // private LocalDateTime createdAt; // Docs

    // @LastModifiedDate
    // @Column(name = "updated_at")
    // private LocalDateTime updatedAt; // Docs

    // MYSQL WAY

    @CreatedDate // No es necesario
    @Column(name = "created_at", insertable = false, updatable = false, columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime created_at;

    @LastModifiedDate // No es necesario
    @Column(name = "updated_at", insertable = false, updatable = false, columnDefinition = "TIMESTAMP on update CURRENT_TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updated_at;

    public LocalDateTime getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return this.updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

}
