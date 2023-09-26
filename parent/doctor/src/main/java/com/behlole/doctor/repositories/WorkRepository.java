package com.behlole.doctor.repositories;

import com.behlole.doctor.models.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface WorkRepository extends JpaRepository<Work, Long> {
}
