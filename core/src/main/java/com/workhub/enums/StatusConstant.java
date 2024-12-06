package com.workhub.enums;

public enum StatusConstant {

    CREATED("CREATED"),
    EDITED("EDITED"),
    DELETED("DELETED");

    private final String status;

    StatusConstant(String status) {
        this.status = status;
    }

    public String getStatus(){
        return this.status;
    }
}
