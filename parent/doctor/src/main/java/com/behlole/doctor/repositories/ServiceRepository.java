package com.behlole.doctor.repositories;

import com.behlole.doctor.models.ServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceModel, Long> {
}
