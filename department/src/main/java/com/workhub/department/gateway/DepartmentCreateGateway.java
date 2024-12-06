package com.workhub.department.gateway;

import com.workhub.department.dto.command.DepartmentCreateCommand;
import com.workhub.department.dto.command.DepartmentEditCommand;
import com.workhub.department.dto.request.DepartmentEditRequest;
import com.workhub.department.dto.request.RequestValidator.DepartmentEditValidator;
import com.workhub.department.service.DepartmentService;
import com.workhub.dto.response.GenericResponse;
import com.workhub.department.dto.request.DepartmentCreateRequest;
import com.workhub.department.dto.request.RequestValidator.DepartmentCreateValidator;
import com.workhub.entity.Department;
import com.workhub.exception.InvalidRequestException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * @author udaya
 */

@Service
@AllArgsConstructor
public class DepartmentCreateGateway {

    private final DepartmentService departmentService;
    private final DepartmentCreateValidator departmentCreateValidator;
    private final DepartmentEditValidator departmentEditValidator;

    public GenericResponse getById(Integer id){
        Department department = departmentService.getById(id)
            .orElseThrow(()-> new InvalidRequestException("Department Not Found"));
        return GenericResponse.builder()
            .message("Department Fetched Successfully.")
            .httpStatus(HttpStatus.OK)
            .success(true)
            .data(department)
            .build();
    }

    public GenericResponse create(DepartmentCreateRequest createRequest){
        DepartmentCreateCommand command = departmentCreateValidator.validate(createRequest);
        departmentService.create(command);
        return GenericResponse.builder()
            .httpStatus(HttpStatus.CREATED)
            .message("Department created successfully.")
            .success(true)
            .build();
    }

    public GenericResponse delete(Integer id){
        Department department = departmentService.getById(id)
            .orElseThrow(()-> new InvalidRequestException("Department not found"));
        departmentService.delete(department);
        return GenericResponse.builder()
            .httpStatus(HttpStatus.OK)
            .message("Department Deleted successfully.")
            .success(true)
            .build();
    }
    public GenericResponse edit(DepartmentEditRequest updateRequest){
        DepartmentEditCommand command = departmentEditValidator.validate(updateRequest);
        Department department = departmentService.edit(command);
        return GenericResponse.builder()
            .httpStatus(HttpStatus.OK)
            .message("Department Edited Successfully.")
            .success(true)
            .data(department)
            .build();
    }

}
