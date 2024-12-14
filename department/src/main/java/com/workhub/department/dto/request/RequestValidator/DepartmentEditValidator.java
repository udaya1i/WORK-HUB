package com.workhub.department.dto.request.RequestValidator;

import com.workhub.dto.request.RequestValidator;
import com.workhub.department.dto.command.DepartmentEditCommand;
import com.workhub.department.dto.mapper.DepartmentEditCommandMapper;
import com.workhub.department.dto.request.DepartmentEditRequest;
import com.workhub.department.service.DepartmentService;
import com.workhub.entity.Department;
import com.workhub.exception.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentEditValidator implements RequestValidator<DepartmentEditRequest, DepartmentEditCommand> {

    private final DepartmentService departmentService;

    @Override
    public DepartmentEditCommand validate(DepartmentEditRequest request) {
        Department department = departmentService.getById(request.getDepartmentId())
                .orElseThrow(() -> new InvalidRequestException("Invalid Department"));
        return DepartmentEditCommandMapper.toDepartmentEditCommand(request, department);

    }
}
