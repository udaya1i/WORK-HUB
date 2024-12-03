package com.workhub.department.repository;

 import com.workhub.department.entity.Department;
 import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    Optional<Department> findByCode(String name);
}
