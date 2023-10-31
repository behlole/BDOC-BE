package com.behlole.cms.service;

import com.behlole.cms.dto.NavigationDto;
import com.behlole.cms.models.Navigation;
import com.behlole.cms.repository.NavigationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NavigationService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    NavigationRepository navigationRepository;

    public List<NavigationDto> getNavigationList() {
        List<Navigation> navigationList = navigationRepository.findAll();
        return navigationList.stream().map(navigation -> modelMapper.map(navigation, NavigationDto.class)).toList();
    }

    public NavigationDto createNavigation(NavigationDto navigationDto) {
        if (navigationDto.getChildren() != null) {
            List<NavigationDto> children = navigationDto.getChildren();
            List<NavigationDto> savedChildren = new ArrayList<>();

            for (NavigationDto child : children) {
                if (child.getId() == null) {
                    savedChildren.add(createNavigation(child));
                } else {
                    savedChildren.add(child);
                }
            }
            navigationDto.setChildren(savedChildren);
        }
        Navigation navigation = navigationRepository.saveAndFlush(modelMapper.map(navigationDto, Navigation.class));
        return modelMapper.map(navigation, NavigationDto.class);
    }

    public void deleteNavigation(Long id) {
        navigationRepository.deleteById(id);
    }

    public void deleteAllNavigations() {
        navigationRepository.deleteAll();
    }
}
