package com.workhub.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
@Table(name = "STATUS")
public class Status extends BaseEntity {

    @Column(name = "STATUS_NAME", nullable = false)
    private String name;

    @Column(name = "STATUS_DESCRIPTION")
    private String description;
}
