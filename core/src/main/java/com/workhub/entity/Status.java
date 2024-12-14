package com.workhub.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Data
@Table(name = "STATUS")
public class Status extends BaseEntity {

    @Column(name = "STATUS_NAME", nullable = false)
    private String name;

    @Column(name = "STATUS_DESCRIPTION")
    private String description;
}
