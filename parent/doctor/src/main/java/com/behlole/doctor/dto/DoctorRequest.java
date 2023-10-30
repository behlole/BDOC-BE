package com.behlole.doctor.dto;

import com.behlole.doctor.models.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorRequest {
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
    @NotNull
    private List<CategoryDto> categories;
    @NotNull
    private List<EducationDto> educationList;
    @NotNull
    private List<ServiceDto> services;
}
