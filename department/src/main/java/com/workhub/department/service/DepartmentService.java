package com.workhub.department.service;

import com.workhub.department.dto.command.DepartmentCreateCommand;
import com.workhub.department.dto.command.DepartmentEditCommand;
import com.workhub.entity.Department;
import com.workhub.department.repository.DepartmentRepository;
import com.workhub.specification.department.DepartmentSpecification;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author udaya
 * */

@Service
@AllArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public void create(DepartmentCreateCommand command){
        Department department = new Department();
        department.setDepartmentName(command.getDepartmentName());
        department.setDescription(command.getDescription());
        department.setCode(command.getCode());
        departmentRepository.save(department);
    }

    public void delete(Department department){
        departmentRepository.delete(department);
    }

    public Department edit(DepartmentEditCommand command){
        Department department = command.getDepartment();
        department.setDepartmentName(command.getDepartmentName());
        department.setDescription(command.getDescription());
        departmentRepository.save(department);
        return department;
    }

    public Optional<Department> getByCode(String code){
       return departmentRepository.findByCode(code);
    }

    public Optional<Department> getByName(String code){
        return departmentRepository.findOne(DepartmentSpecification.findByNameSpecification(code));
    }

    public Optional<Department> getById(Integer id){
        return departmentRepository.findById(id);
    }
}
