package com.behlole.doctor.dto;

import com.behlole.doctor.models.Doctor;
import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty
    @NotEmpty
    private String degree;
    @NotEmpty
    @NotEmpty
    private String institution;
    @NotEmpty
    @NotEmpty
    private LocalDate startDate;
    @NotEmpty
    @NotEmpty
    private LocalDate endDate;


    @NotEmpty
    private DoctorDto doctor;

    public void setStartDate(String startDateString) {
        startDate = LocalDate.parse(startDateString);
    }

    public void setEndDate(String endDateString) {
        endDate = LocalDate.parse(endDateString);
    }
}
