package com.workhub.core.dto.request;

import com.workhub.core.dto.command.Command;

public interface RequestValidator <X extends Request, Y extends Command>{
    Y validate(X request);
}
