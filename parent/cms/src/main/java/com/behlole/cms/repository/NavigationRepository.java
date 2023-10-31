package com.behlole.cms.repository;


import com.behlole.cms.models.Navigation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NavigationRepository extends JpaRepository<Navigation, Long> {
    public List<Navigation> findByIsParentIsTrue();
}
