package com.workhub.teams.service;

import com.workhub.department.repository.StatusRepository;
import com.workhub.entity.Department;
import com.workhub.entity.Teams;
import com.workhub.enums.StatusConstant;
import com.workhub.specification.status.StatusSpecification;
import com.workhub.teams.dto.command.TeamEditCommand;
import com.workhub.teams.repository.TeamsRepository;
import lombok.AllArgsConstructor;
import com.workhub.teams.dto.command.TeamCreateCommand;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TeamService {

    private final TeamsRepository teamsRepository;
    private final StatusRepository statusRepository;

    public List<Teams> getAll() {
        return teamsRepository.findAll(StatusSpecification.notDeletable());
    }

    public Optional<Teams> getById(Integer id) {
        return teamsRepository.findOne(StatusSpecification.statusByIdSpec(id));
    }

    public void createTeam(TeamCreateCommand team) {
        Teams teams = new Teams();
        teams.setName(team.getName());
        teams.setTeamLeader(team.getTeamLeader());
        teams.setStatus(statusRepository.findByName(StatusConstant.CREATED.getStatus()));
        teams.setDescription(team.getDescription());
        teams.setDepartment(team.getDepartment());
        teamsRepository.save(teams);
    }

    public void delete(Teams team) {
        team.setStatus(statusRepository.findByName(StatusConstant.DELETED.getStatus()));
        teamsRepository.save(team);
    }

    public void edit(TeamEditCommand command) {
        Teams teams = command.getTeam();
        teams.setDescription(command.getDescription());
        teams.setTeamLeader(command.getTeamLeader());
        teams.setName(command.getName());
        teams.setDepartment(command.getDepartment());
        teamsRepository.save(teams);
    }

    public Optional<Teams> getByName(String name) {
        return teamsRepository.findByName(name);
    }
}
