package com.behlole.doctor.dto;

import com.behlole.doctor.models.Category;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    private String title;
    @NotBlank
    private String location;
    @NotBlank
    private String rate;
    @NotBlank
    private String aboutMe;
    @NotBlank
    private String phoneNumber;
    private Category categories;
    private List<EducationDto> educationList;
    private List<ServiceDto> services;
}
