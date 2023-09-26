package com.behlole.doctor.dto;

import com.behlole.doctor.models.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {
    private Long id;

    private String name;
    private String email;
    private String title;
    private String location;
    private String rate;
    private String aboutMe;
    private String phoneNumber;
    private Category categories;
    private List<EducationDto> educationList;
    private List<ServiceDto> services;
}
