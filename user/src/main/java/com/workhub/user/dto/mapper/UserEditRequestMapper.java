package com.workhub.user.dto.mapper;

import com.workhub.entity.User;
import com.workhub.user.dto.command.UserEditCommand;
import com.workhub.user.dto.request.UserEditRequest;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserEditRequestMapper {

    public static UserEditCommand to(UserEditRequest userCreateRequest, User user) {
        UserEditCommand command = new UserEditCommand();
        command.setUser(user);
        command.setEmail(userCreateRequest.getEmail());
        command.setPhone(userCreateRequest.getPhone());
        command.setFirstName(userCreateRequest.getFirstName());
        command.setLastName(userCreateRequest.getLastName());
        command.setMiddleName(userCreateRequest.getMiddleName());
        command.setPassword(userCreateRequest.getPassword());
        return command;
    }
}
