package com.behlole.doctor.controllers;

import com.behlole.doctor.dto.DoctorDto;
import com.behlole.doctor.services.DoctorService;
import com.behlole.doctor.utilities.ResponseMappings;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<Object> createNewDoctor(@Valid @RequestBody DoctorDto doctorDto) {
        return responseMappings.getSuccessMessage(doctorService.createDoctor(doctorDto));
    }
}
