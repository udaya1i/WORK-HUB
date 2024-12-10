package com.workhub.service;

import com.workhub.entity.Status;

/**
* @author udaya
*/

public interface Statusable {

Status getStatus();
void setStatus(Status status);

}
