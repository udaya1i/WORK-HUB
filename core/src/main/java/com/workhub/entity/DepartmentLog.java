package com.workhub.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "DEPARTMENT_LOG")
public class DepartmentLog extends BaseEntity {

    @Column(name="Test_Name")
    private String testName;
}
