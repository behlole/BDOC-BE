package com.behlole.doctor.repositories;

import com.behlole.doctor.models.Doctor;
import com.behlole.doctor.models.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {
}
