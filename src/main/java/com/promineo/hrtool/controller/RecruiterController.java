package com.promineo.hrtool.controller;

import com.promineo.hrtool.exception.ResourceNotFoundException;
import com.promineo.hrtool.model.Recruiter;
import com.promineo.hrtool.repository.RecruiterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/recruiter")
public class RecruiterController {
		@Autowired
	    RecruiterRepository recruiterRepository;

	    // Get All Recruiter
	    @GetMapping("/recruiters")
	    public List<Recruiter> getAllRecruiters() {
	        return recruiterRepository.findAll();
	    }
	    // Create a new Recruiter
	    @PostMapping("/recruiters")
	    public Recruiter createRecruiter(@Valid @RequestBody Recruiter recruiter) {
	        return recruiterRepository.save(recruiter);
	    }
	    // Get a Single Recruiter
	    @GetMapping("/recruiters/{id}")
	    public Recruiter getRecruiterById(@PathVariable(value = "id") Long recruiterId) {
	        return recruiterRepository.findById(recruiterId)
	                .orElseThrow(() -> new ResourceNotFoundException("Recruiter", "id", recruiterId));
	    }
	    // Update a Recruiter
	    @PutMapping("/recruiters/{id}")
	    public Recruiter updateRecruiter(@PathVariable(value = "id") Long recruiterId,
	                                            @Valid @RequestBody Recruiter recruiterDetails) {

	        Recruiter recruiter = recruiterRepository.findById(recruiterId)
	                .orElseThrow(() -> new ResourceNotFoundException("Recruiter", "id", recruiterId));

	        recruiter.setTitle(recruiterDetails.getTitle());
	        recruiter.setContent(recruiterDetails.getContent());

	        Recruiter updatedRecruiter = recruiterRepository.save(recruiter);
	        return updatedRecruiter;
	    }
	    // Delete a Recruiter
	    @DeleteMapping("/recruiters/{id}")
	    public ResponseEntity<?> deleteRecruiter(@PathVariable(value = "id") Long recruiterId) {
	        Recruiter recruiter = recruiterRepository.findById(recruiterId)
	                .orElseThrow(() -> new ResourceNotFoundException("Recruiter", "id", recruiterId));

	        recruiterRepository.delete(recruiter);

	        return ResponseEntity.ok().build();
}


}
 