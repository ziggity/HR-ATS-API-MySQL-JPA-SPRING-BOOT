package com.promineo.hrtool.controller;

import com.promineo.hrtool.exception.ResourceNotFoundException;
import com.promineo.hrtool.model.Recruiter;
import com.promineo.hrtool.repository.RecruiterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RecruiterController {

    @Autowired
    RecruiterRepository recruiterRepository;

    // Get All recruiters
    @GetMapping("/recruiters")
    public List<Recruiter> getAllRecruiters() {
        return recruiterRepository.findAll();
    }
    // Create a new recruiter
    @PostMapping("/recruiters")
    public Recruiter createRecruiter(@Valid @RequestBody Recruiter recruiter) {
        return recruiterRepository.save(recruiter);
    }
    // Get a Single recruiter
    @GetMapping("/recruiters/{id}")
    public Recruiter getRecruiterById(@PathVariable(value = "id") Long recruiterId) {
        return recruiterRepository.findById(recruiterId)
                .orElseThrow(() -> new ResourceNotFoundException("recruiter", "id", recruiterId));
    }
    // Update a recruiter
    @PutMapping("/recruiters/{id}")
    public Recruiter updateCandidate(@PathVariable(value = "id") Long recruiterId,
                                            @Valid @RequestBody Recruiter recruiterDetails) {

        Recruiter recruiter = recruiterRepository.findById(recruiterId)
                .orElseThrow(() -> new ResourceNotFoundException("recruiter", "id", recruiterId));
        
        recruiter.setFirstName(recruiterDetails.getFirstName());
        recruiter.setLastName(recruiterDetails.getLastName());
        recruiter.setTitle(recruiterDetails.getTitle());
        recruiter.setLevel(recruiterDetails.getLevel());
        recruiter.setSalary(recruiterDetails.getSalary());

       

        Recruiter updatedRecruiter = recruiterRepository.save(recruiter);
        return updatedRecruiter;
    }
    // Delete a recruiter
    @DeleteMapping("/recruiters/{id}")
    public ResponseEntity<?> deleteCandidate(@PathVariable(value = "id") Long recruiterId) {
        Recruiter recruiter = recruiterRepository.findById(recruiterId)
                .orElseThrow(() -> new ResourceNotFoundException("Recruiter", "id", recruiterId));

        recruiterRepository.delete(recruiter);

        return ResponseEntity.ok().build();
    }
}