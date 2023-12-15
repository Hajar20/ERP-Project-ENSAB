package com.erp.ensab.controller;

import com.erp.ensab.entities.Major;
import com.erp.ensab.repository.MajorRepository;
import com.erp.ensab.services.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/majors")
public class API {
/*
*  JUST FOR TEST !!!!!
    @Autowired
    private MajorRepository majorRepository;


    @PostMapping ("/add")
    public Major addMajor(@RequestBody Major major){
        major.setID(UUID.randomUUID().toString().split("-")[0]);
        System.out.println("Major :"+major);
        return majorRepository.save(major);
    }

    @GetMapping("/all")
    public List<Major> getAllMajors(){
        return majorRepository.findAll();
    }
* */
}

