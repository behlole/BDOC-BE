package com.behlole.doctor.controllers;

import com.behlole.doctor.dto.CategoryDto;
import com.behlole.doctor.dto.DoctorDto;
import com.behlole.doctor.dto.EducationDto;
import com.behlole.doctor.dto.ServiceDto;
import com.behlole.doctor.services.CategoryService;
import com.behlole.doctor.services.DoctorService;
import com.behlole.doctor.services.EducationService;
import com.behlole.doctor.services.ServiceModelService;
import com.behlole.doctor.utilities.ResponseMappings;
import jakarta.validation.Valid;
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


    @GetMapping
    public ResponseEntity<Object> getAllDoctors() {
        return responseMappings.getSuccessMessage(doctorService.getAllDoctors());
    }

    @PostMapping
    public ResponseEntity<Object> createNewDoctor(@Valid @RequestBody DoctorDto doctorDto) {


        List<ServiceDto> serviceDtoList = serviceModelService.createService(doctorDto.getServices());
        doctorDto.setServices(serviceDtoList);

        List<CategoryDto> categoryDto = categoryService.createCategories(doctorDto.getCategories());
        doctorDto.setCategories(categoryDto);

        List<EducationDto> educationDtoList = educationService.createEducation(doctorDto.getEducationList());
        DoctorDto savedDoctorDto = doctorService.createDoctor(doctorDto);

        educationDtoList.stream().map(educationDto -> {
            return educationService.updateEducation(educationDto, savedDoctorDto);
        });

        return responseMappings.getSuccessMessage(savedDoctorDto);
    }
}
