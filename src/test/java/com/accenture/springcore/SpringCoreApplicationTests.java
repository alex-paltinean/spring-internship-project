package com.accenture.springcore;

import com.accenture.springcore.model.Job;
import com.accenture.springcore.service.job.JobService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

@SpringBootTest
class SpringCoreApplicationTests {

    @Autowired
    private JobService jobService;

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    void contextLoads() {
        List<Job> allByLevelAndName = jobService.findAllByLevelAndName(1, null);
        Assertions.assertThat(allByLevelAndName.size()).isEqualTo(2);
    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    void secondTest() {
        // find all (loadData.sql - 2 transactions)
        System.out.println("second test");
    }

}
