package com.workhub.department.dto.mapper;

import com.workhub.department.dto.response.DepartmentResponse;
import com.workhub.entity.Department;

import java.util.List;
import java.util.stream.Collectors;

public class DepartmentResponseMapper {

    public static DepartmentResponse toDepartmentResponse(Department department) {
        DepartmentResponse response = new DepartmentResponse();
        response.setDepartmentId(department.getId());
        response.setDepartmentName(department.getDepartmentName());
        response.setStatus(department.getStatus().getName());
        department.setCode(department.getCode());
        department.setDescription(department.getDescription());
        return response;
    }

    public static List<DepartmentResponse> toDepartment(List<Department> departments) {
        return departments.stream().map(DepartmentResponseMapper::toDepartmentResponse)
                .collect(Collectors.toList());
    }
}
