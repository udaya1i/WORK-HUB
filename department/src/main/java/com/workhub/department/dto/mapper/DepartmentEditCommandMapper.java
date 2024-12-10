package com.workhub.department.dto.mapper;

import com.workhub.department.dto.command.DepartmentEditCommand;
import com.workhub.department.dto.request.DepartmentEditRequest;
import com.workhub.entity.Department;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DepartmentEditCommandMapper {

    public static DepartmentEditCommand toDepartmentEditCommand(
        DepartmentEditRequest request, Department department) {

        DepartmentEditCommand departmentEditCommand = new DepartmentEditCommand();
        departmentEditCommand.setDepartment(department);
        departmentEditCommand.setDepartmentName(request.getDepartmentName());
        departmentEditCommand.setDescription(request.getDescription());
        return departmentEditCommand;

    }
}
