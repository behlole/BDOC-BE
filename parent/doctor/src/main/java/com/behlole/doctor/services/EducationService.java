package com.behlole.doctor.services;

import com.behlole.doctor.dto.EducationDto;
import com.behlole.doctor.models.Education;
import com.behlole.doctor.repositories.EducationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationService {
    @Autowired
    EducationRepository educationRepository;

    @Autowired
    ModelMapper modelMapper;

    public EducationDto convertEducationToEducationDto(Education education) {
        return modelMapper.map(education, EducationDto.class);
    }
    public Education convertEducationToEducationDto(EducationDto educationDto) {
        return modelMapper.map(educationDto, Education.class);
    }

    public List<EducationDto> convertEducationListToEducationDtoList(List<Education> educationList) {
        return educationList.stream().map(this::convertEducationToEducationDto).toList();
    }

    public List<Education> convertEducationDtoToEducationList(List<EducationDto> educationDtoList) {
        return educationDtoList.stream().map(this::convertEducationToEducationDto).toList();
    }

    public List<EducationDto> createEducation(List<EducationDto> educationDtoList) {
        return convertEducationListToEducationDtoList(
                educationRepository.saveAllAndFlush(
                        convertEducationDtoToEducationList(educationDtoList)
                )
        );
    }

}
