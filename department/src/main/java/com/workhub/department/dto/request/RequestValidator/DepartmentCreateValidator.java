package com.workhub.department.dto.request.RequestValidator;

import com.workhub.department.dto.mapper.DepartmentCreateCommandMapper;
import com.workhub.department.service.DepartmentService;
import com.workhub.department.dto.command.DepartmentCreateCommand;
import com.workhub.department.dto.request.DepartmentCreateRequest;
import com.workhub.dto.request.RequestValidator;
import com.workhub.exception.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
/**
 * Validator to validate user request and convert into commadn
 *
 * @author udaya
 */

@Service
@AllArgsConstructor
public class DepartmentCreateValidator implements
    RequestValidator<DepartmentCreateRequest, DepartmentCreateCommand> {

    private final DepartmentService departmentService;

    @Override
    public DepartmentCreateCommand validate(DepartmentCreateRequest request) {
        departmentService.getByCode(request.getCode()).ifPresent((department) -> {
           throw new InvalidRequestException("Department with code "+ department.getCode()+" already exist.");
         });
        return DepartmentCreateCommandMapper.toDepartmentCreateCommand(request);
    }
}
