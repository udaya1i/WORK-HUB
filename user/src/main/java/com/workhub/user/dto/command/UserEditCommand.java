package com.workhub.user.dto.command;

import com.workhub.dto.command.Command;
import com.workhub.entity.User;
import lombok.Data;

@Data
public class UserEditCommand implements Command {

    private User user;

    private String firstName;

    private String middleName;

    private String lastName;

    private String email;

    private String password;

    private String phone;

 }
