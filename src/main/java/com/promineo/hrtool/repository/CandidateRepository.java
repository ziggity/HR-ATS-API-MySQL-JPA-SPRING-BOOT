package com.promineo.hrtool.repository;

import com.promineo.hrtool.model.Candidate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
 
}
