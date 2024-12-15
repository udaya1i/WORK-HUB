package com.workhub.user.dto.request.requestValidator;


import com.workhub.dto.request.RequestValidator;
import com.workhub.exception.InvalidRequestException;
import com.workhub.user.dto.command.UserCreateCommand;
import com.workhub.user.dto.mapper.UserCreateRequestMapper;
import com.workhub.user.dto.request.UserCreateRequest;
import com.workhub.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserCreateRequestValidator implements RequestValidator<UserCreateRequest, UserCreateCommand> {

    private final UserService userService;

    @Override
    public UserCreateCommand validate(UserCreateRequest request) {
        userService.getByName(request.getUserName()).ifPresent((user)->{
            throw new InvalidRequestException("Username already exists");
        });
        return UserCreateRequestMapper.to(request);
    }
}
