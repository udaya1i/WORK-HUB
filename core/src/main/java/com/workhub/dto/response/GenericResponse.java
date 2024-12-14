package com.workhub.dto.response;


 import lombok.Builder;
 import lombok.Getter;
 import org.springframework.http.HttpStatus;

@Getter
@Builder
public class GenericResponse<T>{
    private String message;
    private T data;
    private boolean success;
    private HttpStatus httpStatus;
}
