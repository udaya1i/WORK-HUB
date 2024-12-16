package com.workhub.user.controller;

import com.workhub.constant.ApiConstant;
import com.workhub.dto.response.GenericResponse;
import com.workhub.user.dto.request.UserCreateRequest;
import com.workhub.user.dto.request.UserEditRequest;
import com.workhub.user.gateway.UserGateway;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = ApiConstant.USER)
public class UserController {

    private final UserGateway gateway;

    @GetMapping
    public ResponseEntity<GenericResponse> getALl() {
        return ResponseEntity.status(HttpStatus.OK).body(gateway.getAll());
    }

    @GetMapping(path = ApiConstant.ID)
    public ResponseEntity<GenericResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(gateway.getById(id));
    }

    @PostMapping(path = ApiConstant.CREATE)
    public ResponseEntity<GenericResponse> create(@RequestBody @Valid UserCreateRequest teamCreateRequest) {
        GenericResponse response = gateway.create(teamCreateRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping(path = ApiConstant.EDIT)
    public ResponseEntity<GenericResponse> edit(UserEditRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(gateway.edit(request));
    }

    @PostMapping(path = ApiConstant.DELETE + "/" + ApiConstant.ID)
    public ResponseEntity<GenericResponse> delete(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(gateway.delete(id));
    }
}
