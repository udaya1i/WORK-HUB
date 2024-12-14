package com.workhub.teams.dto.command;

import com.workhub.dto.command.Command;
import com.workhub.entity.Department;
import com.workhub.entity.Teams;
import lombok.Data;

@Data
public class TeamEditCommand implements Command {

    private String name;
    private String description;
    private String teamLeader;
    private Integer department;
    private Teams team;
}
