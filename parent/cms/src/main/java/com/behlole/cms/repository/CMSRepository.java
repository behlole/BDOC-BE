package com.behlole.cms.repository;

import com.behlole.cms.models.CMS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CMSRepository extends JpaRepository<CMS, Long> {
}
