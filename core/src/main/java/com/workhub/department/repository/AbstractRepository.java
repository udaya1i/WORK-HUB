package com.workhub.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Abstract repository interface that provides basic CRUD operations and
 * specification executor functionality for entities.
 *
 * @param <T>  Entity type
 * @param <R> Id type of the primary key
 * @author udaya
 * */

@NoRepositoryBean
public interface AbstractRepository <T extends Object, R extends  Object>
    extends JpaRepository<T, R>, JpaSpecificationExecutor<T>{
}
