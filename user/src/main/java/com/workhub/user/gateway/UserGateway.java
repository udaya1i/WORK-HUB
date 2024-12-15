package com.workhub.user.gateway;

import com.workhub.dto.response.GenericResponse;
import com.workhub.user.dto.command.UserCreateCommand;
import com.workhub.user.dto.command.UserEditCommand;
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

    public GenericResponse create(UserCreateRequest request){
        UserCreateCommand command = createRequestValidator.validate(request);
        userService.createTeam(command);
        return GenericResponse.builder()
                .httpStatus(HttpStatus.CREATED)
                .message("User Created Successfully")
                .data(null)
                .success(true)
                .build();
    }


}
