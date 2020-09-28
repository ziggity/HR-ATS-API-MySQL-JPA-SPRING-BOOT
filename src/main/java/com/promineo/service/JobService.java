package com.promineo.service;
import com.promineo.hrtool.model.Job;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.promineo.hrtool.model.Job;
import com.promineo.hrtool.repository.JobRepository;

@Service
public interface JobService {
	 static final Logger Logger = LogManager.getLogger(CandidateService.class);


}
