package com.workhub.teams.dto.request.validator;

import com.workhub.dto.request.RequestValidator;
import com.workhub.entity.Teams;
import com.workhub.exception.InvalidRequestException;
import com.workhub.teams.dto.command.TeamEditCommand;
import com.workhub.teams.dto.mapper.TeamEditRequestMapper;
import com.workhub.teams.dto.request.TeamEditRequest;
import com.workhub.teams.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TeamEditRequestValidator implements RequestValidator<TeamEditRequest, TeamEditCommand> {

    private final TeamService service;

    @Override
    public TeamEditCommand validate(TeamEditRequest request) {
        Teams teams = service.getById(request.getId()).orElseThrow(() ->
                new InvalidRequestException("Team does not exist"));
        return TeamEditRequestMapper.to(request, teams);
    }
}
