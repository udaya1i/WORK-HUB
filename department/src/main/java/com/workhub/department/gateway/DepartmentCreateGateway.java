package com.workhub.department.gateway;

import com.workhub.department.dto.command.DepartmentCreateCommand;
import com.workhub.department.service.DepartmentService;
import com.workhub.core.dto.response.GenericResponse;
import com.workhub.department.dto.request.DepartmentCreateRequest;
import com.workhub.department.dto.request.RequestValidator.DepartmentCreateValidator;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentCreateGateway {

    private final DepartmentService departmentService;
    private final DepartmentCreateValidator departmentCreateValidator;

    public GenericResponse create(DepartmentCreateRequest createRequest){
        DepartmentCreateCommand command = departmentCreateValidator.validate(createRequest);
        departmentService.createDepartment(command);
        return GenericResponse.builder()
            .httpStatus(HttpStatus.CREATED)
            .message("Department created successfully.")
            .success(true)
            .build();
    }
}
