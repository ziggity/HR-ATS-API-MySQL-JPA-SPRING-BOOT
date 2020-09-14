package com.promineo.hrtool.repository;

import com.promineo.hrtool.model.Recruiter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruiterRepository extends JpaRepository<Recruiter, Long>{

}
