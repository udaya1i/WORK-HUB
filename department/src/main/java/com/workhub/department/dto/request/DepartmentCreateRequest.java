package com.workhub.department.dto.request;

import com.workhub.dto.request.Request;
import com.workhub.validator.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentCreateRequest implements Request {

    @Required
    private String departmentName;

    @Required
    private String description;

    @Required
    private String code;
}
