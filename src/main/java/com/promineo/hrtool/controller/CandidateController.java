package com.promineo.hrtool.controller;

import com.promineo.hrtool.exception.ResourceNotFoundException;
import com.promineo.hrtool.model.Candidate;
import com.promineo.hrtool.repository.CandidateRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CandidateController {

    @Autowired
    CandidateRepository candidateRepository;

    // Get All Candidate
    @GetMapping("/candidates")
    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }
    // Create a new Candidate
    @PostMapping("/candidates")
    public Candidate createCandidate(@Valid @RequestBody Candidate candidate) {
        return candidateRepository.save(candidate);
    }
    // Get a Single Candidate
    @GetMapping("/candidates/{id}")
    public Candidate getCandidateById(@PathVariable(value = "id") Long candidateId) {
        return candidateRepository.findById(candidateId)
                .orElseThrow(() -> new ResourceNotFoundException("Candidate", "id", candidateId));
    }
    // Update a Candidate
    @PutMapping("/candidates/{id}")
    public Candidate updateCandidate(@PathVariable(value = "id") Long candidateId,
                                            @Valid @RequestBody Candidate candidateDetails) {

        Candidate candidate = candidateRepository.findById(candidateId)
                .orElseThrow(() -> new ResourceNotFoundException("Candidate", "id", candidateId));

        candidate.setTitle(candidateDetails.getTitle());
        candidate.setContent(candidateDetails.getContent());

        Candidate updatedCandidate = candidateRepository.save(candidate);
        return updatedCandidate;
    }
    // Delete a Candidate
    @DeleteMapping("/candidates/{id}")
    public ResponseEntity<?> deleteCandidate(@PathVariable(value = "id") Long candidateId) {
        Candidate candidate = candidateRepository.findById(candidateId)
                .orElseThrow(() -> new ResourceNotFoundException("Candidate", "id", candidateId));

        candidateRepository.delete(candidate);

        return ResponseEntity.ok().build();
    }
}