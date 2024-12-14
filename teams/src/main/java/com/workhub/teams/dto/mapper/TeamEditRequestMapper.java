package com.workhub.teams.dto.mapper;

import com.workhub.entity.Teams;
import com.workhub.teams.dto.command.TeamEditCommand;
import com.workhub.teams.dto.request.TeamEditRequest;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TeamEditRequestMapper {

    public static TeamEditCommand to(TeamEditRequest teamEditRequest, Teams team) {
        TeamEditCommand teamEditCommand = new TeamEditCommand();
        teamEditCommand.setTeamLeader(teamEditRequest.getTeamLeader());
        teamEditCommand.setDescription(teamEditRequest.getDescription());
        teamEditCommand.setName(teamEditRequest.getName());
        teamEditCommand.setDepartment(teamEditRequest.getDepartment());
        teamEditCommand.setTeam(team);
        return teamEditCommand;
    }
}
