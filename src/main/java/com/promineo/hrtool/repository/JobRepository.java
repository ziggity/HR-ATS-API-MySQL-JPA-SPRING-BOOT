package com.promineo.hrtool.repository;

import com.promineo.hrtool.model.Job;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long>{


}
