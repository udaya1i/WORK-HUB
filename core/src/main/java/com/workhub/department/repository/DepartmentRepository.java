package com.workhub.department.repository;

 import com.workhub.repository.AbstractRepository;
 import com.workhub.entity.Department;
 import java.util.Optional;
import org.springframework.stereotype.Repository;

/**
 * @author udaya
 * */

@Repository
public interface DepartmentRepository extends AbstractRepository<Department, Integer> {

    Optional<Department> findByCode(String name);
}
