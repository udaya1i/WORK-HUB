package com.workhub.core.dto.response;


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
//
//    public GenericResponse(Builder builder) {
//        this.message = builder.message;
//        this.data = builder.data;
//        this.success = builder.success;
//        this.httpStatus = builder.httpStatus;
//    }
//    public static class Builder<T>{
//        private T data;
//        private boolean success;
//        private String message;
//        private HttpStatus httpStatus;
//
//        public Builder<T> message(String message){
//            this.message = message;
//            return this;
//        }
//        public Builder<T> data(T data){
//            this.data = data;
//            return this;
//        }
//        public Builder<T> success(boolean success){
//            this.success = success;
//            return this;
//        }
//        public Builder<T> httpStatus(HttpStatus httpStatus){
//            this.httpStatus = httpStatus;
//            return this;
//        }
//        public static GenericResponse<T> build(){
//            return new GenericResponse<>(this);
//        }
//    }
}
