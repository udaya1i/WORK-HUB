package com.workhub.department.service;

import com.workhub.department.dto.command.DepartmentCreateCommand;
import com.workhub.department.dto.command.DepartmentEditCommand;
import com.workhub.department.repository.DepartmentRepository;
import com.workhub.department.repository.StatusRepository;
import com.workhub.entity.Department;
import com.workhub.enums.StatusConstant;
import com.workhub.specification.status.StatusSpecification;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author udaya
 * */

@Service
@AllArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final StatusRepository statusRepository;

    public void create(DepartmentCreateCommand command){
        Department department = new Department();
        department.setDepartmentName(command.getDepartmentName());
        department.setDescription(command.getDescription());
        department.setCode(command.getCode());
        department.setStatus(statusRepository.findByName(StatusConstant.CREATED.getStatus()));
        departmentRepository.save(department);
    }

    public Department edit(DepartmentEditCommand command){
        Department department = command.getDepartment();
        department.setDepartmentName(command.getDepartmentName());
        department.setDescription(command.getDescription());
        department.setStatus(statusRepository.findByName(StatusConstant.EDITED.getStatus()));
        departmentRepository.save(department);
        return department;
    }

    public void delete(Department department){
        department.setStatus(statusRepository.findByName(StatusConstant.DELETED.getStatus()));
        departmentRepository.save(department);
    }

    public Optional<Department> getByCode(String code){
       return departmentRepository.findByCode(code);
    }

    public Optional<Department> getById(Integer id){
        return departmentRepository.findById(id);
    }

    public List<Department> getAll(){
         return departmentRepository.findAll(StatusSpecification.notDeletable());
    }
}
