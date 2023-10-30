package com.behlole.doctor.controllers;

import com.behlole.doctor.dto.*;
import com.behlole.doctor.services.CategoryService;
import com.behlole.doctor.services.DoctorService;
import com.behlole.doctor.services.EducationService;
import com.behlole.doctor.services.ServiceModelService;
import com.behlole.doctor.utilities.ResponseMappings;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorController {
    @Autowired
    ResponseMappings responseMappings;
    @Autowired
    EducationService educationService;
    @Autowired
    ServiceModelService serviceModelService;
    @Autowired
    DoctorService doctorService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<Object> getAllDoctors() {
        return responseMappings.getSuccessMessage(doctorService.getAllDoctors());
    }

    @PostMapping
    public ResponseEntity<Object> createNewDoctor(@Valid @RequestBody DoctorRequest doctorDto) {

        /**
         * Assign Services to Doctor
         */
        doctorDto.setServices(serviceModelService.createService(doctorDto.getServices()));
        /**
         * Assign Categories to Doctor
         */
        doctorDto.setCategories(categoryService.createCategories(doctorDto.getCategories()));
        DoctorDto savedDoctorDto = doctorService.createDoctor(modelMapper.map(doctorDto, DoctorDto.class));

        educationService.updateEducationDtoList(
                doctorDto.getEducationList(), modelMapper.map(savedDoctorDto, DoctorDto.class)
        );
        List<EducationDto> educationDtoList = educationService.createEducation(doctorDto.getEducationList())
                .stream()
                .peek(educationDto -> educationDto.setDoctor(null)).toList();
        savedDoctorDto.setEducationDtos(
                educationDtoList
        );
        return responseMappings.getSuccessMessage(savedDoctorDto);
    }
}
