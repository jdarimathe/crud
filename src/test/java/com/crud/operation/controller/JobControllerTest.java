//package com.crud.operation.controller;
//
//
//import com.crud.operation.model.Job;
//import com.crud.operation.service.JobService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.mockito.ArgumentMatchers.anyLong;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//@WebMvcTest(JobController.class)
//public class JobControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private JobService jobService;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Test
//    public void getJobsTest() throws Exception {
//
//        mockMvc.perform(get("/jobs")
//                        .accept(MediaType.parseMediaType("application/json")))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType("application/json"));
//    }
//
//    @Test
//    public void saveJobTest() throws Exception {
//        Job job = new Job();
//
//        mockMvc.perform(post("/job")
//                        .contentType("application/json")
//                        .content(objectMapper.writeValueAsString(job)))
//                .andExpect(status().isCreated());
//    }
//
//    @Test
//    public void updateJobTest() throws Exception {
//        Job job = new Job();
//
//        mockMvc.perform(put("/job/{id}",anyLong())
//                        .contentType("application/json")
//                        .content(objectMapper.writeValueAsString(job)))
//                .andExpect(status().isCreated());
//    }
//
//    @Test
//    public void deleteJobTest() throws Exception {
//
//        mockMvc.perform(delete("/job/{id}",anyLong())
//                        .contentType("application/json"))
//                .andExpect(status().isOk());
//    }
//
//}
