package com.behlole.doctor.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceModel {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private Long id;
    private String serviceName;
    @ManyToMany(targetEntity = Doctor.class)
    private List<Doctor> doctors;
}
