package com.workhub.user.dto.mapper;

import com.workhub.entity.User;
import com.workhub.user.dto.response.UserResponse;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class UserResponseMapper {

    public static List<UserResponse> toResponse(List<User> users) {
        return users.stream().map(UserResponseMapper::toUserResponse).collect(Collectors.toList());
    }

    public static UserResponse toUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setUserName(user.getUserName());
        userResponse.setPhone(user.getPhone());
        userResponse.setEmail(user.getEmail());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setMiddleName(user.getMiddleName());
        userResponse.setLastName(user.getLastName());
        return userResponse;
    }
}
