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
public class Doctor {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private Long id;

    private String name;
    private String email;
    private String title;
    private String location;
    private String rate;
    private String aboutMe;
    private String phoneNumber;
    @ManyToMany(targetEntity = Category.class)
    private List<Category> categories;

    @OneToMany(mappedBy = "doctor")
    private List<Education> educationList;

    @ManyToMany(targetEntity = ServiceModel.class)
    private List<ServiceModel> services;
}
