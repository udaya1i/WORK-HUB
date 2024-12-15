package com.workhub.user.dto.mapper;

import com.workhub.user.dto.command.UserCreateCommand;
import com.workhub.user.dto.request.UserCreateRequest;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserCreateRequestMapper {

    public static UserCreateCommand to(UserCreateRequest userCreateRequest){
        UserCreateCommand userCreateCommand = new UserCreateCommand();
        userCreateCommand.setUserName(userCreateRequest.getUserName());
        userCreateCommand.setPassword(userCreateRequest.getPassword());
        userCreateCommand.setEmail(userCreateRequest.getEmail());
        userCreateCommand.setPhone(userCreateRequest.getPhone());
        userCreateCommand.setFirstName(userCreateRequest.getFirstName());
        userCreateCommand.setLastName(userCreateRequest.getLastName());
        userCreateCommand.setMiddleName(userCreateRequest.getMiddleName());
        return userCreateCommand;
    }
}
