package com.workhub.specification.department;

import com.workhub.entity.Department;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author udaya
 */

public class DepartmentSpecification {

    public static Specification<Department> findByNameSpecification(String name) {
        return ((root, query, criteriaBuilder) ->
            criteriaBuilder.like(root.get("name"), "%" + name + "%"));
    }
}
