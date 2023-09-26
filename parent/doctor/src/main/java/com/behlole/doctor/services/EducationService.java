package com.behlole.doctor.services;

import com.behlole.doctor.dto.EducationDto;
import com.behlole.doctor.models.Education;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationService {
    public EducationDto convertEducationToEducationDto(Education education) {
        EducationDto educationDto = new EducationDto();
        educationDto.setId(education.getId());
        educationDto.setInstitution(education.getInstitution());
        educationDto.setEndDate(education.getEndDate().toString());
        educationDto.setStartDate(education.getStartDate().toString());
        educationDto.setDegree(education.getDegree());
        return educationDto;
    }

    public Education convertEducationToEducationDto(EducationDto educationDto) {
        Education education = new Education();
        education.setId(education.getId());
        education.setInstitution(educationDto.getInstitution());
        education.setEndDate(educationDto.getEndDate());
        education.setStartDate(educationDto.getStartDate());
        education.setDegree(education.getDegree());
        return education;
    }

    public List<EducationDto> convertEducationListToEducationDtoList(List<Education> educationList) {
        return educationList.stream().map(this::convertEducationToEducationDto).toList();
    }

    public List<Education> convertEducationDtoToEducationList(List<EducationDto> educationDtoList) {
        return educationDtoList.stream().map(this::convertEducationToEducationDto).toList();
    }

}
