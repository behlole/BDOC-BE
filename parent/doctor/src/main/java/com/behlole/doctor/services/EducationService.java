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
        educationDto.setInstitution(educationDto.getInstitution());
        educationDto.setEndDate(educationDto.getEndDate());
        educationDto.setStartDate(educationDto.getStartDate());
        educationDto.setDegree(education.getDegree());
        return educationDto;
    }

    public List<EducationDto> convertEducationListToEducationDtoList(List<Education> educationList) {
        return educationList.stream().map(this::convertEducationToEducationDto).toList();
    }
}
