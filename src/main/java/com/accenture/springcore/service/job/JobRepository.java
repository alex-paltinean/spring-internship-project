package com.accenture.springcore.service.job;

import com.accenture.springcore.model.Job;
import com.accenture.springcore.service.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends BaseRepository<Job, Integer> {


    List<Job> findAllByLevel(Integer level);

    @Query("select j from Job j where (:level is null or j.level=:level) and (:name is null or j.name like :name)")
    List<Job> findAllByLevelAndNameContains(@Param("level") Integer level, @Param("name") String name, Pageable page);

    @Query(value = "select * from job where level = :level and name = :name", nativeQuery = true)
    List<Job> findAllByLevelAndNameContainsNative(@Param("level") Integer level, @Param("name") String name);
}
