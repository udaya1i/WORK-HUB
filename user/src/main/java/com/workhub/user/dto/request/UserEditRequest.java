package com.workhub.user.dto.request;

import lombok.Data;

@Data
public class UserEditRequest {

    private String firstName;

    private String middleName;

    private String lastName;

    private String email;

    private String password;

    private String phone;
}
