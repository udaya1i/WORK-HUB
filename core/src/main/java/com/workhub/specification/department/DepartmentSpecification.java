package com.workhub.specification.department;

import com.workhub.entity.Department;
import org.springframework.data.jpa.domain.Specification;

public class DepartmentSpecification {

    public static Specification<Department> nameLike(String search) {
        return ((root, query, criteriaBuilder) -> {

        })
    }
}
