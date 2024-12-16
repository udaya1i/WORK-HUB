package com.workhub.user.dto.response;

import lombok.Data;

@Data
public class UserResponse {

    private String userName;

    private String firstName;

    private String middleName;

    private String lastName;

    private String email;

    private String phone;
}
