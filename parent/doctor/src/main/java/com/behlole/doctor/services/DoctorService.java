package com.behlole.doctor.services;

import com.behlole.doctor.dto.DoctorDto;
import com.behlole.doctor.models.Doctor;
import com.behlole.doctor.repositories.DoctorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    EducationService educationService;

    @Autowired
    ServiceModelService serviceModelService;

    public List<DoctorDto> getAllDoctors() {
        return doctorRepository.findAll().stream().map(this::parseDoctorToDoctorDto).toList();
    }

    public DoctorDto createDoctor(DoctorDto doctorDto) {
        Doctor doctor = parseDoctorDtoToDoctor(doctorDto);
        this.doctorRepository.saveAndFlush(doctor);
        return modelMapper.map(doctor, DoctorDto.class);
    }

    private Doctor parseDoctorDtoToDoctor(DoctorDto doctorDto) {
        return modelMapper.map(doctorDto, Doctor.class);
    }

    private DoctorDto parseDoctorToDoctorDto(Doctor doctor) {
        return modelMapper.map(doctor, DoctorDto.class);
    }
}
