package com.workhub.department.dto.command;

import com.workhub.dto.command.Command;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentCreateCommand implements Command {
    private String departmentName;
    public String code;
    private String description;
}
