package com.workhub.teams.repository;

import com.workhub.department.repository.AbstractRepository;
import com.workhub.entity.Teams;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamsRepository extends AbstractRepository<Teams, Integer> {
    Optional<Teams> findByName(String name);
}
