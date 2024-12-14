package com.workhub.dto.request;

import com.workhub.dto.command.Command;

/**
 * @author udaya
 * @param <X> raw user request
 * @param <Y> payload to persist on db after validation.
 */


public interface RequestValidator<X extends Request, Y extends Command> {
    Y validate(X request);
}
