package com.workhub.dto.request;

import com.workhub.dto.command.Command;

public interface RequestValidator <X extends Request, Y extends Command>{
    Y validate(X request);
}
