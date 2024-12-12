package com.workhub.teams.dto;

import com.workhub.dto.command.Command;
import com.workhub.entity.Department;
import lombok.Data;

@Data
public class TeamCreateCommand implements Command {

    private String name;
    private String description;
    private String teamLeader;
    private Department department;
}
