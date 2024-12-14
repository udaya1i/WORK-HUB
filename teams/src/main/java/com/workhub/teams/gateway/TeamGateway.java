package com.workhub.teams.gateway;

import com.workhub.dto.response.GenericResponse;
import com.workhub.entity.Teams;
import com.workhub.exception.InvalidRequestException;
import com.workhub.teams.dto.command.TeamCreateCommand;
import com.workhub.teams.dto.command.TeamEditCommand;
import com.workhub.teams.dto.mapper.TeamsResponseMapper;
import com.workhub.teams.dto.request.TeamCreateRequest;
import com.workhub.teams.dto.request.TeamEditRequest;
import com.workhub.teams.dto.request.validator.TeamCreateRequestValidator;
import com.workhub.teams.dto.request.validator.TeamEditRequestValidator;
import com.workhub.teams.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TeamGateway {

    private final TeamService teamService;
    private final TeamCreateRequestValidator teamCreateRequestValidator;
    private final TeamEditRequestValidator teamEditRequestValidator;


    public GenericResponse getAll() {
        return GenericResponse
                .builder()
                .success(true)
                .message("Teams Fetched Successfully.")
                .data(TeamsResponseMapper.toResponse(teamService.getAll()))
                .build();
    }

    public GenericResponse getById(Integer id) {
        Teams teams = teamService.getById(id).orElseThrow(() ->
                new InvalidRequestException("Team with id " + id + " not found"));
        return GenericResponse
                .builder()
                .success(true)
                .httpStatus(HttpStatus.OK)
                .message("Team details fetched successfully.")
                .data(TeamsResponseMapper.toTeamResponse(teams))
                .build();
    }

    public GenericResponse create(TeamCreateRequest request) {
        TeamCreateCommand createCommand = teamCreateRequestValidator.validate(request);
        teamService.createTeam(createCommand);
        return GenericResponse.builder()
                .httpStatus(HttpStatus.CREATED)
                .success(true)
                .message("Team Created Successfully.")
                .data(null)
                .build();
    }

    public GenericResponse edit(TeamEditRequest request) {
        TeamEditCommand command = teamEditRequestValidator.validate(request);
        teamService.edit(command);
        return GenericResponse.builder()
                .httpStatus(HttpStatus.CREATED)
                .success(true)
                .message("Team Edited Successfully.")
                .data(null)
                .build();
    }

    public GenericResponse delete(Integer id) {
        Teams teams = teamService.getById(id).orElseThrow(() ->
                new InvalidRequestException("Team with id " + id + " not found"));
        teamService.delete(teams);
        return GenericResponse
                .builder()
                .success(true)
                .httpStatus(HttpStatus.OK)
                .message("Team Deleted successfully.")
                .data(null)
                .build();
    }

}
