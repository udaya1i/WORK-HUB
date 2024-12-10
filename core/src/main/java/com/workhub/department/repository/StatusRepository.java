package com.workhub.department.repository;

import com.workhub.entity.Status;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends AbstractRepository<Status, Integer> {
     Status findByName(String status);
}
