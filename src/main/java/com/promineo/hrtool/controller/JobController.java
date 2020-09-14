package com.promineo.hrtool.controller;

import com.promineo.hrtool.exception.ResourceNotFoundException;
import com.promineo.hrtool.model.Job;
import com.promineo.hrtool.repository.JobRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class JobController {

    @Autowired
    JobRepository jobRepository;

    // Get All Job
    @GetMapping("/jobs")
    public List<JobRepository> getAllJobs() {
        return jobRepository.findAll();
    }
    // Create a new Job
    @PostMapping("/jobs")
    public Job createJob(@Valid @RequestBody Job job) {
        return jobRepository.save(job);
    }
    // Get a Single Job
    @GetMapping("/jobs/{id}")
    public JobRepository getJobById(@PathVariable(value = "id") Long jobId) {
        return jobRepository.findById(jobId)
                .orElseThrow(() -> new ResourceNotFoundException("Job", "id", jobId));
    }
    // Update a Job
    @PutMapping("/jobs/{id}")
    public JobRepository updateJob(@PathVariable(value = "id") Long jobId,
                                            @Valid @RequestBody Job jobDetails) {

        JobRepository job = jobRepository.findById(jobId)
                .orElseThrow(() -> new ResourceNotFoundException("Job", "id", jobId));

        job.setTitle(jobDetails.getTitle());
        job.setContent(jobDetails.getContent());

        JobRepository updatedJob = jobRepository.save(job);
        return updatedJob;
    }
    // Delete a Job
    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<?> deleteJob(@PathVariable(value = "id") Long jobId) {
        JobRepository job = jobRepository.findById(jobId)
                .orElseThrow(() -> new ResourceNotFoundException("Job", "id", jobId));

        jobRepository.delete(job);

        return ResponseEntity.ok().build();
    }
}