package com.workhub.specification.status;

import com.workhub.entity.Status;
import com.workhub.enums.StatusConstant;
import com.workhub.service.Statusable;
import jakarta.persistence.criteria.Path;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

/**
 *   @author udaya
 */

@NoArgsConstructor
public class StatusSpecification {

        public static final <T extends Statusable> Specification<T> notDeletable(Class<T> clazz) {
            return (root, criteriaQuery, criteriaBuilder) ->{
                Path<Status> statusPath = root.get("status");
                return criteriaBuilder.notEqual(statusPath.get("name"), StatusConstant.DELETED.getStatus());
            };
        }


}
