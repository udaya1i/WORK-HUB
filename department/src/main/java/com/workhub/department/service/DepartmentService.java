package com.workhub.department.service;

import com.workhub.department.dto.command.DepartmentCreateCommand;
import com.workhub.department.entity.Department;
import com.workhub.department.repository.DepartmentRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public void createDepartment(DepartmentCreateCommand command){
        Department department = new Department();
        department.setDepartmentName(command.getDepartmentName());
        department.setDescription(command.getDescription());
        department.setCode(command.getCode());
        departmentRepository.save(department);
    }

    public Optional<Department> getDepartmentByCode(String code){
       return departmentRepository.findByCode(code);

    }
}
