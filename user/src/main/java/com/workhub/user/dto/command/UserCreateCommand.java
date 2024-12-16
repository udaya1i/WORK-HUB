package com.workhub.user.dto.command;

import com.workhub.dto.command.Command;
import lombok.Data;

@Data
public class UserCreateCommand implements Command {


    private String userName;

    private String firstName;

    private String middleName;

    private String lastName;

    private String email;

    private String password;

    private String phone;

}
