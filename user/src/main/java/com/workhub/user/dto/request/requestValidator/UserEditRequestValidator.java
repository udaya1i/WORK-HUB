package com.workhub.user.dto.request.requestValidator;

import com.workhub.dto.request.RequestValidator;
import com.workhub.entity.User;
import com.workhub.exception.InvalidRequestException;
import com.workhub.user.dto.command.UserEditCommand;
import com.workhub.user.dto.mapper.UserEditRequestMapper;
import com.workhub.user.dto.request.UserEditRequest;
import com.workhub.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserEditRequestValidator implements RequestValidator<UserEditRequest, UserEditCommand> {

    private final UserService userService;

    @Override
    public UserEditCommand validate(UserEditRequest request) {
        User user = userService.getById(request.getId()).orElseThrow(
                ()-> new InvalidRequestException("User with id "+request.getId()+" does not exist."));
      return UserEditRequestMapper.to(request, user);
    }
}
