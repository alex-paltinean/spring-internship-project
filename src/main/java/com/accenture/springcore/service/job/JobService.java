package com.accenture.springcore.service.job;

import com.accenture.springcore.model.Job;
import com.accenture.springcore.service.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class JobService extends BaseService<Job, Integer> {

    private final JobRepository jobRepository;

    private final JobDao jobDao;

    @Override
    public boolean validateEntity(Job entity) {
        return false;
    }

    public List<Job> findAllByLevelAndName(Integer level, String name) {
//        new ArrayList<String>()
//                .stream()
//                .filter(s -> s.contains("s"))
//                .map(s -> s)
//                .collect(Collectors.toList());
        System.out.println("From findAllByLevelAndName()");
        return jobDao.findAllByLevelAndNameContains(level, name);
    }

    public boolean hasByLevelAndName(Integer level, String name) {
        return findAllByLevelAndName(level, name).size() > 0;
    }

    public List<Job> findAllByLevelAndNameSorted(Integer level, String name) {
        return jobRepository.findAllByLevelAndNameContains(level, name, PageRequest.of(0, 10, Sort.by("level")));
    }
}
