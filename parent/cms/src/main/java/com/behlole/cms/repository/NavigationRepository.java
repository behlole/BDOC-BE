package com.behlole.cms.repository;


import com.behlole.cms.models.Navigation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface NavigationRepository extends JpaRepository<Navigation, Long> {
    public List<Navigation> findByIsParent(Boolean isParent);

    public List<Navigation> deleteByUuid(UUID uuid);
}
