package com.workhub.user.gateway;

import com.workhub.dto.response.GenericResponse;
import com.workhub.entity.User;
import com.workhub.exception.InvalidRequestException;
import com.workhub.user.dto.command.UserCreateCommand;
import com.workhub.user.dto.command.UserEditCommand;
import com.workhub.user.dto.mapper.UserResponseMapper;
import com.workhub.user.dto.request.UserCreateRequest;
import com.workhub.user.dto.request.UserEditRequest;
import com.workhub.user.dto.request.requestValidator.UserCreateRequestValidator;
import com.workhub.user.dto.request.requestValidator.UserEditRequestValidator;
import com.workhub.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.function.ServerResponse;

@Service
@AllArgsConstructor
public class UserGateway {

    private final UserService userService;
    private final UserCreateRequestValidator createRequestValidator;
    private final UserEditRequestValidator editRequestValidator;


    public GenericResponse getAll() {
        return GenericResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("User(s) fetched Successfully")
                .data(UserResponseMapper.toResponse(this.userService.getAll()))
                .success(true)
                .build();
    }

    public GenericResponse getById(Integer id) {
        return GenericResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("User fetched Successfully")
                .data(UserResponseMapper.toResponse(this.userService.getAll()))
                .success(true)
                .build();
    }

    public GenericResponse create(UserCreateRequest request) {
        UserCreateCommand command = createRequestValidator.validate(request);
        userService.createTeam(command);
        return GenericResponse.builder()
                .httpStatus(HttpStatus.CREATED)
                .message("User Created Successfully")
                .data(null)
                .success(true)
                .build();
    }

    public GenericResponse edit(UserEditRequest request) {
        UserEditCommand command = editRequestValidator.validate(request);
        User user = userService.edit(command);
        return GenericResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("User Edited Successfully")
                .data(user)
                .success(true)
                .build();
    }

    public GenericResponse delete(Integer id) {
        User user = userService.getById(id).orElseThrow(() -> new InvalidRequestException("User Not Found"));
        userService.delete(user);
        return GenericResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("User Deleted Successfully")
                .data(user)
                .success(true)
                .build();
    }


}
