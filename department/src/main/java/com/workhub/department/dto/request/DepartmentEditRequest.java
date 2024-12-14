package com.workhub.department.dto.request;

import com.workhub.dto.request.Request;
import com.workhub.validator.*;
import lombok.Data;

@Data
public class DepartmentEditRequest implements Request {


    private Integer departmentId;

    @Required
    private String departmentName;

    @Required
    private String description;
}
