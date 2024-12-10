package com.workhub.department.dto.response;

import com.workhub.entity.Status;
import lombok.Data;

@Data
public class DepartmentResponse {
    private Integer departmentId;
    private String departmentName;
    private String departmentCode;
    private String description;
    private String status;
}
