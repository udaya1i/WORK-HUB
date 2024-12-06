package com.workhub.department.controller;

import com.workhub.constant.ApiConstant;
import com.workhub.dto.response.GenericResponse;
import com.workhub.department.dto.request.DepartmentCreateRequest;
import com.workhub.department.dto.request.DepartmentEditRequest;
import com.workhub.department.gateway.DepartmentCreateGateway;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping(ApiConstant.ID)
    public ResponseEntity<GenericResponse> getById(@PathVariable Integer id){
        return ResponseEntity.ok(departmentCreateGateway.getById(id));
    }

    @PostMapping(ApiConstant.CREATE)
    public ResponseEntity<GenericResponse> create(@Valid @RequestBody DepartmentCreateRequest department){
        GenericResponse response = departmentCreateGateway.create(department);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

    @PostMapping(ApiConstant.DELETE+"/"+ApiConstant.ID)
    public ResponseEntity<GenericResponse> delete(@PathVariable Integer id){
        GenericResponse response = departmentCreateGateway.delete(id);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }
    @PostMapping(ApiConstant.EDIT)
    public ResponseEntity<GenericResponse> edit(@Valid @RequestBody DepartmentEditRequest departmentEditRequest){
        GenericResponse response = departmentCreateGateway.edit(departmentEditRequest);
        return ResponseEntity.status(response.getHttpStatus()).body(response);
    }

}
