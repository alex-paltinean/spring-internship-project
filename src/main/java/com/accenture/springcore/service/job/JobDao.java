package com.accenture.springcore.service.job;

import com.accenture.springcore.model.Job;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class JobDao {

    private final EntityManager em;

    List<Job> findAllByLevelAndNameContains(Integer level, String name) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Job> criteriaQuery = cb.createQuery(Job.class);

        Root<Job> job = criteriaQuery.from(Job.class);
        List<Predicate> predicates = new ArrayList<>();
        if (level != null) {
            predicates.add(cb.equal(job.get("level"), level));
        }
        if (name != null) {
            predicates.add(cb.like(job.get("name"), "%" + name + "%"));
        }

        Predicate[] predicates1 = new Predicate[predicates.size()];
        predicates.toArray(predicates1);
        criteriaQuery.where(predicates1);

        TypedQuery<Job> query = em.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
