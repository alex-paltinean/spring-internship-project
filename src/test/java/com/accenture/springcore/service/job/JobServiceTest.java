package com.accenture.springcore.service.job;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
class JobServiceTest {

    @Mock
    private JobRepository jobRepository;

    @Mock
    private JobDao jobDao;

    @Spy
    @InjectMocks
    private JobService jobService;

    @Test
    void findAllByLevelAndName() {
        Mockito.when(jobDao.findAllByLevelAndNameContains(Mockito.anyInt(), Mockito.anyString())).thenReturn(new ArrayList<>());

        jobService.findAllByLevelAndName(1, "job1");

        ArgumentCaptor<Integer> levelCaptor = ArgumentCaptor.forClass(Integer.class);
        ArgumentCaptor<String> nameCaptor = ArgumentCaptor.forClass(String.class);
        Mockito.verify(jobDao, Mockito.times(1)).findAllByLevelAndNameContains(levelCaptor.capture(), nameCaptor.capture());
        Assertions.assertThat(levelCaptor.getValue()).isEqualTo(1);
        Assertions.assertThat(nameCaptor.getValue()).isEqualTo("job1");
    }

    @Test
    void hasAllByLevelAndName() {
        Mockito.doReturn(new ArrayList<>()).when(jobService).findAllByLevelAndName(Mockito.anyInt(), Mockito.anyString());

        boolean hasByLevelAndName = jobService.hasByLevelAndName(1, "job1");

        ArgumentCaptor<Integer> levelCaptor = ArgumentCaptor.forClass(Integer.class);
        ArgumentCaptor<String> nameCaptor = ArgumentCaptor.forClass(String.class);
        Mockito.verify(jobService, Mockito.times(1)).findAllByLevelAndName(levelCaptor.capture(), nameCaptor.capture());
        Assertions.assertThat(levelCaptor.getValue()).isEqualTo(1);
        Assertions.assertThat(nameCaptor.getValue()).isEqualTo("job1");
        Assertions.assertThat(hasByLevelAndName).isEqualTo(false);
    }
}