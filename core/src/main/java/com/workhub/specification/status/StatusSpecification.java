package com.workhub.specification.status;

import com.workhub.entity.Status;
import com.workhub.enums.StatusConstant;
import com.workhub.service.Statusable;
import jakarta.persistence.criteria.Path;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author udaya
 */

public class StatusSpecification {

    /**
     * @param <T> The entity type that implements Statusable.
     * @return Specification for non-deletable entities.
     */
    public static <T extends Statusable> Specification<T> notDeletable() {
        return (root, criteriaQuery, criteriaBuilder) -> {
            Path<Status> statusPath = root.get("status");
            return criteriaBuilder.notEqual(statusPath.get("name"), StatusConstant.DELETED.getStatus());
        };
    }

    /**
     * @param id The ID of the entity.
     * @param <T> The entity type that implements Statusable.
     * @return Specification for filtering by ID.
     */
    public static <T extends Statusable> Specification<T> byIdSpec(Number id) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("id"), id);
    }

    /**
     * @param id The ID of the entity.
     * @return Combined Specification for filtering by ID and non-deletable status.
     */
    public static <T extends Statusable> Specification<T> statusByIdSpec(Number id) {
        return (Specification<T>) Specification.where(byIdSpec(id)).and(notDeletable());
    }
}
