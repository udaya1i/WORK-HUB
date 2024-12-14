package com.workhub.teams.dto.response;

import com.workhub.entity.Status;
import lombok.Data;

@Data
public class TeamResponse {

    private String name;
    private String description;
    private String teamLeader;
    private DepartmentResponse department;
    private String status;

}
