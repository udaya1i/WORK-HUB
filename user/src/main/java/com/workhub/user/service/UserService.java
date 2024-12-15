package com.workhub.user.service;

import com.workhub.department.repository.StatusRepository;
import com.workhub.entity.Teams;
import com.workhub.entity.User;
import com.workhub.enums.StatusConstant;
import com.workhub.specification.status.StatusSpecification;
import com.workhub.user.dto.command.UserCreateCommand;
import com.workhub.user.dto.command.UserEditCommand;
import com.workhub.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final StatusRepository statusRepository;

    public List<Teams> getAll() {
        return userRepository.findAll(StatusSpecification.notDeletable());
    }

    public Optional<Teams> getById(Integer id) {
        return userRepository.findOne(StatusSpecification.statusByIdSpec(id));
    }

    public void createTeam(UserCreateCommand command) {
        User user = new User();
        user.setUserName(command.getUserName());
        user.setFirstName(command.getFirstName());
        user.setMiddleName(command.getMiddleName());
        user.setLastName(command.getLastName());
        user.setEmail(command.getEmail());
        user.setPassword(command.getPassword())
        user.setPhone(command.getPhone());
        user.setStatus(statusRepository.findByName(StatusConstant.CREATED.getStatus()));
        userRepository.save(user);

    }

    public void edit(UserEditCommand command) {
        User user = command.getUser();
        user.setFirstName(command.getFirstName());
        user.setMiddleName(command.getMiddleName());
        user.setLastName(command.getLastName());
        user.setEmail(command.getEmail());
        user.setPhone(command.getPhone());
        user.setStatus(statusRepository.findByName(StatusConstant.EDITED.getStatus()));
        userRepository.save(user);
    }

    public void delete(User user) {
        user.setStatus(statusRepository.findByName(StatusConstant.DELETED.getStatus()));
        userRepository.save(user);
    }

    public Optional<User> getByName(String name) {
        return userRepository.findByName(name);
    }


}
