package com.promineo.hrtool.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String sayHello() {
        return "Hello and welcome! Use http://localhost:8080/api/candidates to see all candidates \n"
        		+ "Use http://localhost:8080/api/recruiters to see all recruiters \n "
        		+ "Use http://localhost:8080/api/jobs to see all jobs";
    }
}
