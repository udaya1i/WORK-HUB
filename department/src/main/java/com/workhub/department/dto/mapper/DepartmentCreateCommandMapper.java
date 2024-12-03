package com.workhub.department.dto.mapper;

import com.workhub.department.dto.command.DepartmentCreateCommand;
import com.workhub.department.dto.request.DepartmentCreateRequest;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DepartmentCreateCommandMapper {
    
    public static DepartmentCreateCommand toDepartmentCreateCommand(
        DepartmentCreateRequest request){
        DepartmentCreateCommand command = new DepartmentCreateCommand();
        command.setDepartmentName(request.getDepartmentName());
        command.setDescription(request.getDescription());
        command.setCode(request.getCode());
        return command;
    }

}
