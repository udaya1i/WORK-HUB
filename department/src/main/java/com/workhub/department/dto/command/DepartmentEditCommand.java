package com.workhub.department.dto.command;

import com.workhub.dto.command.Command;
import com.workhub.entity.Department;
import lombok.Data;

@Data
public class DepartmentEditCommand implements Command {
    private Department department;
    private String departmentName;
    private String description;
}
