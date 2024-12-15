package com.workhub.user.repository;

import com.workhub.department.repository.AbstractRepository;
import com.workhub.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends AbstractRepository<User, Integer> {
    public Optional<User> findByName(String username);
}
