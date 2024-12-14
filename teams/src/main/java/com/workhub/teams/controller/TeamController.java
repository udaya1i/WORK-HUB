package com.workhub.teams.controller;

import com.workhub.constant.ApiConstant;
import com.workhub.dto.response.GenericResponse;
import com.workhub.teams.dto.request.TeamCreateRequest;
import com.workhub.teams.dto.request.TeamEditRequest;
import com.workhub.teams.gateway.TeamGateway;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping(path = ApiConstant.TEAM)
public class TeamController {

    private final TeamGateway gateway;

    @GetMapping
    public ResponseEntity<GenericResponse> getALl() {
        return ResponseEntity.status(HttpStatus.OK).body(gateway.getAll());
    }

    @GetMapping(path = ApiConstant.ID)
    public ResponseEntity<GenericResponse> getById(Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(gateway.getById(id));
    }

    @PostMapping(path = ApiConstant.CREATE)
    public ResponseEntity<GenericResponse> create(@RequestBody @Valid TeamCreateRequest teamCreateRequest) {
        GenericResponse response = gateway.create(teamCreateRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping(path = ApiConstant.EDIT)
    public ResponseEntity<GenericResponse> edit(TeamEditRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(gateway.edit(request));
    }

    @PostMapping(path = ApiConstant.DELETE + "/" + ApiConstant.ID)
    public ResponseEntity<GenericResponse> delete(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(gateway.delete(id));
    }


}


