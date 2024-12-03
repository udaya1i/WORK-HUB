package com.workhub.department.controller;

import com.workhub.core.constant.ApiConstant;
import com.workhub.core.dto.response.GenericResponse;
import com.workhub.department.dto.request.DepartmentCreateRequest;
import com.workhub.department.gateway.DepartmentCreateGateway;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@AllArgsConstructor
@RestController
@RequestMapping(path = ApiConstant.DEPARTMENT)
public class DepartmentController {

    private final DepartmentCreateGateway departmentCreateGateway;

    @PostMapping(ApiConstant.CREATE)
    public ResponseEntity<GenericResponse> createDepartment(@Valid @RequestBody DepartmentCreateRequest department){
        GenericResponse response = departmentCreateGateway.create(department);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

}
