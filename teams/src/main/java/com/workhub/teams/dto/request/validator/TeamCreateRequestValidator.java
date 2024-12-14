package com.workhub.teams.dto.request.validator;

import com.workhub.dto.request.RequestValidator;
import com.workhub.teams.dto.command.TeamCreateCommand;
import com.workhub.teams.dto.mapper.TeamCreateCommandMapper;
import com.workhub.teams.dto.request.TeamCreateRequest;
import com.workhub.teams.service.TeamService;
import jakarta.validation.ValidationException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TeamCreateRequestValidator implements RequestValidator<TeamCreateRequest, TeamCreateCommand> {

    private final TeamService teamService;

    @Override
    public TeamCreateCommand validate(TeamCreateRequest request) {
        teamService.getByName(request.getName()).ifPresent((team -> {
            throw new ValidationException("Team name already exists");
        }));
        return TeamCreateCommandMapper.to(request);
    }
}
