package com.workhub.teams.dto.mapper;

import com.workhub.teams.dto.command.TeamCreateCommand;
import com.workhub.teams.dto.request.TeamCreateRequest;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TeamCreateCommandMapper {

    public static TeamCreateCommand to(TeamCreateRequest request) {
        TeamCreateCommand command = new TeamCreateCommand();
        command.setDescription(request.getDescription());
        command.setName(request.getName());
        command.setTeamLeader(request.getTeamLeader());
        command.setDepartment(request.getDepartmentId());
        return command;
    }
}
