package com.apple.wipro.covid19.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apple.wipro.covid19.entity.CovidStatesEntity;
import com.apple.wipro.covid19.entity.CovidTotalEntity;
import com.apple.wipro.covid19.repository.CovidRepository;
import com.apple.wipro.covid19.repository.CovidStatesRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping(value="/covid")
public class TestController {

    // standard constructors
   
    @Autowired
    CovidRepository covidRepository;
    
    @Autowired
    CovidStatesRepository covidStatesRepository;


    @GetMapping("/welcome")
    public String getIndex() {
        return "Hi prakash...how are you"; 
    }

    @GetMapping("/list/total")
    public List<CovidTotalEntity> getAllTotal() {
        return (List<CovidTotalEntity>) covidRepository.findAll();
    }
    
    
    @GetMapping("/db/states")
    public List<CovidStatesEntity> getAllStates() {
    	System.out.println("@@@@@inside getAll State@@@@@@@");
        List<CovidStatesEntity>  li =  covidStatesRepository.findAll();
        //System.out.println("List value:::;"+li);
        //return new ResponseEntity<List<CovidStatesEntity>>(li,HttpStatus.OK);
        return li;
    }
    

    @PostMapping("/create/total")
    void addTotal(@RequestBody CovidTotalEntity total) {
    	System.out.println("@@@@@@@@insode add Total@@@@@@@"+total.toString());
    	covidRepository.save(total);
    }
    
    @GetMapping("/hello")
    public String sayHello() {
    	System.out.println("Hi Prakash.....Good Morning");
    	return "Good Morning";
    }
}
