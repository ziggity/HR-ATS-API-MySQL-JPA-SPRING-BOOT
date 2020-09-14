package com.promineo.hrtool.repository;

import com.promineo.hrtool.model.Job;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<JobRepository, Long>{

}
