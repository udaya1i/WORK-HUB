package com.workhub.entity;

import com.workhub.service.Statusable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "DEPARTMENT")
public class Department extends BaseEntity implements Statusable {

    @Column(name = "DEPARTMENT_NAME", nullable = false)
    private String departmentName;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "DEPARTMENT_CODE")
    private String code;

    @JoinColumn(name = "status", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Status status;


}
