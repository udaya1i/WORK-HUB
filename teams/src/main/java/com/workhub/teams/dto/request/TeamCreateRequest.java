package com.workhub.teams.dto.request;

import com.workhub.dto.request.Request;
import com.workhub.entity.Department;
import com.workhub.validator.Required;
import lombok.Data;

@Data
public class TeamCreateRequest implements Request {

    @Required
    private String name;

    @Required
    private String description;

    private String teamLeader;

    @Required
    private Department department;

}
