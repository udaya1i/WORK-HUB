package com.workhub.department.dto.request;

import com.workhub.core.dto.request.Request;
import com.workhub.core.validator.Required;
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
