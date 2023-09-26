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

    public DoctorDto createDoctor(DoctorDto doctorDto) {
        this.doctorRepository.saveAndFlush(parseDoctorDtoToDoctor(doctorDto));
        return doctorDto;
    }

    private Doctor parseDoctorDtoToDoctor(DoctorDto doctorDto) {
        Doctor doctor = new Doctor();
        doctor.setId(doctorDto.getId());
        doctor.setName(doctorDto.getName());
        doctor.setEmail(doctorDto.getEmail());
        doctor.setTitle(doctorDto.getTitle());
        doctor.setLocation(doctorDto.getLocation());
        doctor.setRate(doctorDto.getRate());
        doctor.setAboutMe(doctorDto.getAboutMe());
        doctor.setCategories(doctorDto.getCategories());
        doctor.setEducationList(educationService.convertEducationDtoToEducationList(doctorDto.getEducationList()));
        if (doctorDto.getServices() != null)
            doctor.setServices(serviceModelService.convertServiceListDtoToServiceModelList(doctorDto.getServices()));
        return doctor;
    }

    private DoctorDto parseDoctorToDoctorDto(Doctor doctor) {
        DoctorDto doctorDto = new DoctorDto();
        doctorDto.setId(doctor.getId());
        doctorDto.setName(doctor.getName());
        doctorDto.setEmail(doctor.getEmail());
        doctorDto.setTitle(doctor.getTitle());
        doctorDto.setLocation(doctor.getLocation());
        doctorDto.setRate(doctor.getRate());
        doctorDto.setAboutMe(doctor.getAboutMe());
        doctorDto.setCategories(doctor.getCategories());
        doctorDto.setEducationList(educationService.convertEducationListToEducationDtoList(doctor.getEducationList()));
        doctorDto.setServices(serviceModelService.convertServiceListToServiceDtoList(doctor.getServices()));
        return doctorDto;
    }
}
