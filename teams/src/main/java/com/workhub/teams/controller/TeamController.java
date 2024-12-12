package com.workhub.teams.controller;

import com.workhub.dto.response.GenericResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TeamController {


    public ResponseEntity<GenericResponse> getALl(){
        return new ResponseEntity<>();
    }

    public ResponseEntity<GenericResponse> getById(Long id){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<GenericResponse> create(){
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public ResponseEntity<GenericResponse> edit(Long id){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<GenericResponse> delete(Long id){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
