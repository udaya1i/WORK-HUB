package com.workhub.department.entity;

 import com.workhub.core.entity.BaseEntity;
 import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name =  "DEPARTMENT")
public class Department extends BaseEntity {

    @Column(name = "DEPARTMENT_NAME", nullable = false)
    private String departmentName;

    @Column(name = "DESCRIPTION",nullable = false)
    private String description;

    @Column(name = "DEPARTMENT_CODE")
    private String code;

}
