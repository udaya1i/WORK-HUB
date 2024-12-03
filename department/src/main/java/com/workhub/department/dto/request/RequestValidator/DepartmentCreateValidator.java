package com.workhub.department.dto.request.RequestValidator;

import com.workhub.department.dto.mapper.DepartmentCreateCommandMapper;
import com.workhub.department.service.DepartmentService;
import com.workhub.department.dto.command.DepartmentCreateCommand;
import com.workhub.department.dto.request.DepartmentCreateRequest;
import com.workhub.core.dto.request.RequestValidator;
import java.util.InputMismatchException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentCreateValidator implements
    RequestValidator<DepartmentCreateRequest, DepartmentCreateCommand> {

    private final DepartmentService departmentService;

    @Override
    public DepartmentCreateCommand validate(DepartmentCreateRequest request) {
        departmentService.getDepartmentByCode(request.getCode()).ifPresent((department) -> {
            throw new InputMismatchException("Department with the code "+ request.getCode() +" already exist.");
        });
        return DepartmentCreateCommandMapper.toDepartmentCreateCommand(request);
    }
}
