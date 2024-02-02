package com.jangir.loanservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity {
    @Column(updatable = false, name = "created_at")
    private LocalDateTime createdAt;

    @Column(updatable = false, name = "created_by")
    private String createdBy;

    @Column(insertable = false, name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(insertable = false, name = "updated_by")
    private String updatedBy;
}
