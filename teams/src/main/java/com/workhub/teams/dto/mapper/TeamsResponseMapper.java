package com.workhub.teams.dto.mapper;

import com.workhub.entity.Department;
import com.workhub.entity.Teams;
import com.workhub.teams.dto.response.DepartmentResponse;
import com.workhub.teams.dto.response.TeamResponse;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class TeamsResponseMapper {


    public static List<TeamResponse> toResponse(List<Teams> teams) {
        return teams.stream().map(TeamsResponseMapper::toTeamResponse).collect(Collectors.toList());
    }

    public static TeamResponse toTeamResponse(Teams teams) {
        TeamResponse team = new TeamResponse();
        team.setName(teams.getName());
        team.setDescription(teams.getDescription());
        team.setStatus(teams.getStatus().getName());
        team.setDepartment(team.getDepartment());
        team.setTeamLeader(teams.getTeamLeader());
        return team;
    }

    // TODO: map with department
    private DepartmentResponse toDepartmentResponse(Department department) {
        DepartmentResponse departmentResponse = new DepartmentResponse();
        departmentResponse.setId(department.getId());
        departmentResponse.setName(departmentResponse.getName());
        return departmentResponse;
    }
}
