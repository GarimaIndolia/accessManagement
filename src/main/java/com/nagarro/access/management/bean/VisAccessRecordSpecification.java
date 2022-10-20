package com.nagarro.access.management.bean;

import java.time.LocalDateTime;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

public class VisAccessRecordSpecification implements Specification<VisAccessRecord>{

    private VisAccessRecord filter;

    public VisAccessRecordSpecification(VisAccessRecord filter) {
        super();
        this.filter = filter;
    }

    public Predicate toPredicate(Root<VisAccessRecord> root, CriteriaQuery<?> cq,
            CriteriaBuilder cb) {

        Predicate p = cb.disjunction();

        if (filter.getVisitorId() != null) {
            p.getExpressions()
                    .add(cb.equal(root.get("visitorId"), filter.getVisitorId()));
        }
        if (filter.getTimeIn() != null ) {
            p.getExpressions().add(
                    cb.and(cb.lessThanOrEqualTo(root.get("timeIn"), LocalDateTime.now()),cb.greaterThanOrEqualTo(root.get("timeIn"), filter.getTimeIn())));
        }
        return p;
    }


}
