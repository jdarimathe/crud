//package com.crud.operation.service;
//
//import com.crud.operation.exception.ResourceFoundException;
//import com.crud.operation.model.Job;
//import com.crud.operation.repository.JobRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.ArgumentMatchers.anyLong;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.any;
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.never;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.verifyNoMoreInteractions;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//class JobServiceTest {
//    @InjectMocks
//    private JobService jobService;
//
//    @Mock
//    private JobRepository jobRepository;
//
//    private Job job;
//
//    @BeforeEach
//    public void setup() {
//        job = new Job();
//        job.setId(1L);
//        job.setJobName("Software Developer");
//        job.setJobType("Full-time");
//        job.setJobLocation("New York");
//        job.setJobDescription("Develop software applications");
//    }
//
//    @Test
//    void getAllJobsTest() {
//        when(jobRepository.findAll()).thenReturn(List.of(job, job));
//
//        assertThat(jobService.getJobs().size());
//        verify(jobRepository, times(1)).findAll();
//        verifyNoMoreInteractions(jobRepository);
//    }
//
//    @Test
//    void saveJobTest() throws ResourceFoundException {
//
//        given(jobRepository.findById(job.getId())).willReturn(Optional.empty());
//
//        given(jobRepository.save(job)).willReturn(job);
//
//        Job savedJob = jobService.saveJob(job);
//
//        assertThat(savedJob).isNotNull();
//    }
//
//    @Test
//    void saveJobTestWhenThrowsException() {
//        when(jobRepository.findById(job.getId())).thenReturn(Optional.of(job));
//
//        assertThrows(ResourceFoundException.class, () -> jobService.saveJob(job));
//
//        verify(jobRepository, never()).save(any(Job.class));
//    }
//
//    @Test
//    void findJobByIdTest() throws ResourceFoundException {
//        when(jobRepository.findById(anyLong())).thenReturn(Optional.of(job));
//
//        final var actual = jobService.getJobById(2);
//
//        assertThat(actual).isEqualTo(job);
//        verify(jobRepository, times(1)).findById(anyLong());
//    }
//
//    @Test
//    void findJobByIdTestWhenThrowException() {
//
//        when(jobRepository.findById(anyLong())).thenReturn(Optional.empty());
//
//        assertThrows(ResourceFoundException.class, () -> jobService.getJobById(anyLong()));
//        verify(jobRepository, times(1)).findById(anyLong());
//
//    }
//
//    @Test
//    void deleteJobTest()  {
//        doNothing().when(jobRepository).deleteById(anyLong());
//
//        jobService.deleteJob(anyLong());
//        verify(jobRepository, times(1)).deleteById(anyLong());
//
//    }
//
//    @Test
//    public void testUpdateJob() {
//
//        when(jobRepository.save(job)).thenReturn(job);
//
//        job.setId(2L);
//        job.setJobType("Part-time");
//        job.setJobName("Software II");
//        job.setJobLocation("Ohio");
//        job.setJobDescription("Develop software ");
//
//        Job jobUpdate = jobService.updateJob(job);
//
//        assertThat(jobUpdate).isEqualTo(job);
//        verify(jobRepository, times(1)).save(job);
//
//    }
//
//}
