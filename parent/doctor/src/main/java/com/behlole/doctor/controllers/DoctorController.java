package com.behlole.doctor.controllers;

import com.behlole.doctor.services.DoctorService;
import com.behlole.doctor.utilities.ResponseMappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorController {
    @Autowired
    ResponseMappings responseMappings;

    @Autowired
    DoctorService doctorService;


    @GetMapping
    public ResponseEntity<Object> getAllDoctors() {
        return responseMappings.getSuccessMessage(doctorService.getAllDoctors());
    }
//    @PostMapping
//    public ResponseEntity<Object> createNewDoctor(){
//
//    }
}
