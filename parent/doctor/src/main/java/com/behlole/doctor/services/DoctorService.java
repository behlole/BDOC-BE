package com.behlole.doctor.services;

import com.behlole.doctor.dto.DoctorDto;
import com.behlole.doctor.models.Doctor;
import com.behlole.doctor.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    EducationService educationService;

    @Autowired
    ServiceModelService serviceModelService;

    public List<DoctorDto> getAllDoctors() {
        return doctorRepository.findAll().stream().map(this::parseDoctorToDoctorDto).toList();
    }

    public DoctorDto parseDoctorToDoctorDto(Doctor doctor) {
        DoctorDto doctorDto = new DoctorDto();
        doctorDto.setId(doctorDto.getId());
        doctorDto.setName(doctorDto.getName());
        doctorDto.setEmail(doctor.getEmail());
        doctorDto.setTitle(doctor.getTitle());
        doctorDto.setLocation(doctor.getLocation());
        doctorDto.setRate(doctor.getRate());
        doctorDto.setAboutMe(doctorDto.getAboutMe());
        doctorDto.setCategories(doctor.getCategories());
        doctorDto.setEducationList(educationService.convertEducationListToEducationDtoList(doctor.getEducationList()));
        doctorDto.setServices(serviceModelService.convertServiceListToServiceDtoList(doctor.getServices()));
        return doctorDto;
    }
}
