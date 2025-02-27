package com.behlole.cms.repository;


import com.behlole.cms.models.Navigation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NavigationRepository extends JpaRepository<Navigation, Long> {
    public Optional<List<Navigation>> findByIsParent(Boolean isParent);

    public Optional<List<Navigation>> findAllByUuidIn(List<UUID> uuid);

    public Optional<Navigation> findByUuid(UUID uuid);

}
