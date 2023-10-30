package com.behlole.doctor.services;

import com.behlole.doctor.dto.DoctorDto;
import com.behlole.doctor.dto.EducationDto;
import com.behlole.doctor.models.Doctor;
import com.behlole.doctor.models.Education;
import com.behlole.doctor.repositories.EducationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationService {
    @Autowired
    EducationRepository educationRepository;

    @Autowired
    ModelMapper modelMapper;

    public EducationDto convertEducationToEducationDto(Education education) {
        return modelMapper.map(education, EducationDto.class);
    }

    public Education convertEducationDTOToEducation(EducationDto educationDto) {
        return modelMapper.map(educationDto, Education.class);
    }

    public List<EducationDto> convertEducationListToEducationDtoList(List<Education> educationList) {
        return educationList.stream().map(this::convertEducationToEducationDto).toList();
    }

    public List<Education> convertEducationDtoToEducationList(List<EducationDto> educationDtoList) {
        return educationDtoList.stream().map(this::convertEducationDTOToEducation).toList();
    }

    public List<EducationDto> createEducation(List<EducationDto> educationDtoList) {
        return convertEducationListToEducationDtoList(
                educationRepository.saveAllAndFlush(
                        convertEducationDtoToEducationList(educationDtoList)
                )
        );
    }

    public EducationDto updateEducation(EducationDto educationDto, DoctorDto doctorDto) {
        Optional<Education> education = educationRepository.findById(educationDto.getId());
        if (education.isPresent()) {
            Education education1 = education.get();
            education1.setDoctor(modelMapper.map(doctorDto, Doctor.class));
            educationRepository.save(education1);
            return modelMapper.map(education1, EducationDto.class);
        } else {
            throw new EntityNotFoundException("Doctor with ID " + educationDto.getId() + " not found");
        }
    }


    public List<EducationDto> updateEducationDtoList(List<EducationDto> educationDtos, DoctorDto doctorDto) {
        return educationDtos.stream().map(educationDto -> {
            educationDto.setDoctor(doctorDto);
            return educationDto;
        }).toList();
    }

    public EducationDto createSingleEducation(EducationDto educationDto) {
        return modelMapper.map(educationRepository.saveAndFlush(convertEducationDTOToEducation(educationDto)), EducationDto.class);
    }

    public List<EducationDto> createEducation(List<EducationDto> educationDtoList, DoctorDto doctorDto) {
        educationDtoList.stream().map(educationDto -> {
            educationDto.setDoctor(doctorDto);
            return educationDto;
        });
        return convertEducationListToEducationDtoList(
                educationRepository.saveAllAndFlush(
                        convertEducationDtoToEducationList(educationDtoList)
                )
        );
    }

}
