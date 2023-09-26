package com.behlole.doctor.dto;

import com.behlole.doctor.models.Doctor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EducationDto {
    private Long id;
    private String degree;
    private String institution;
    private LocalDate startDate;
    private LocalDate endDate;
}
