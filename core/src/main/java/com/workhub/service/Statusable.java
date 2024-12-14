package com.workhub.service;


import com.workhub.entity.Status;

/**
 * @author udaya
 */

public interface Statusable {
    /**
     * Gets the status of the entity.
     *
     * @return the current status.
     */
    Status getStatus();

    /**
     * Sets the status of the entity.
     *
     * @param status the new status to set.
     */
    void setStatus(Status status);


}
