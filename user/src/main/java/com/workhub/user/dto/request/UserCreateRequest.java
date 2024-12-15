package com.workhub.user.dto.request;


import com.workhub.dto.request.Request;
import lombok.Data;

@Data
public class UserCreateRequest implements Request {

    private String userName;

    private String firstName;

    private String middleName;

    private String lastName;

    private String email;

    private String password;

    private String phone;

}
