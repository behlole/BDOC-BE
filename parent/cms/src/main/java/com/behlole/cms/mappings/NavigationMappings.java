package com.behlole.cms.mappings;

import com.behlole.cms.dto.UpdateNavigationDto;
import com.behlole.cms.models.Navigation;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface NavigationMappings {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateNavigationFromDto(UpdateNavigationDto dto, @MappingTarget Navigation entity);
}
