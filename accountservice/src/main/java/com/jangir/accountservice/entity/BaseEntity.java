package com.jangir.accountservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @Column(updatable = false, name = "created_at")

    @CreatedDate
    public LocalDateTime createdAt;

    @Column(updatable = false, name = "created_by")
    @CreatedBy
    public String createdBy;

    @Column(insertable = false, name = "updated_at")
    @LastModifiedDate
    public LocalDateTime updatedAt;

    @Column(insertable = false, name = "updated_by")
    @LastModifiedBy
    public String updatedBy;
}
