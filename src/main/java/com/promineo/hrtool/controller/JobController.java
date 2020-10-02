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

    // Get All jobs
    @GetMapping("/jobs")
    public List<Job> getAllJobs() {
        return jobRepository.findAll();

    }
    // Create a new job
    @PostMapping("/jobs")
    public Job createJob(@Valid @RequestBody Job job) {
        return jobRepository.save(job);
    }
    // Get a Single job
    @GetMapping("/jobs/{id}")
    public Job getJobById(@PathVariable(value = "id") Long jobId) {
        return jobRepository.findById(jobId)
                .orElseThrow(() -> new ResourceNotFoundException("job", "id", jobId));
    }
    // Update a job
    @PutMapping("/jobs/{id}")
    public Job updateJob(@PathVariable(value = "id") Long jobId,
                                            @Valid @RequestBody Job jobDetails) {

        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new ResourceNotFoundException("job", "id", jobId));

        job.setTitle(jobDetails.getTitle());
        job.setContent(jobDetails.getContent());
        job.setPay(jobDetails.getPay());

        Job updatedJob = jobRepository.save(job);
        return updatedJob;
    }
    // Delete a job
    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<?> deleteJob(@PathVariable(value = "id") Long jobId) {
        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new ResourceNotFoundException("Job", "id", jobId));

        jobRepository.delete(job);

        return ResponseEntity.ok().build();
    }
}