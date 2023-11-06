package com.behlole.cms.service;

import com.behlole.cms.dto.NavigationDto;
import com.behlole.cms.models.Navigation;
import com.behlole.cms.repository.NavigationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class NavigationService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    NavigationRepository navigationRepository;

    public List<NavigationDto> getNavigationList() {
        List<Navigation> navigationList = navigationRepository.findByIsParent(true);
        return navigationList.stream().map(navigation -> modelMapper.map(navigation, NavigationDto.class)).toList();
    }

    public NavigationDto createNavigation(NavigationDto navigationDto) {
        if (navigationDto.getChildren() != null) {
            List<NavigationDto> children = navigationDto.getChildren();
            List<NavigationDto> savedChildren = new ArrayList<>();

            for (NavigationDto child : children) {
                if (child.getUuid() == null) {
                    savedChildren.add(createNavigation(child));
                } else {
                    savedChildren.add(child);
                }
            }
            navigationDto.setChildren(savedChildren);
        }
        if (navigationDto.getIsParent() == null) {
            navigationDto.setIsParent(false);
        }

        Navigation navigation = navigationRepository.saveAndFlush(modelMapper.map(navigationDto, Navigation.class));
        if (navigation.getChildren() != null) {
            List<Navigation> savedChildren = new ArrayList<>();
            navigation.getChildren().forEach(singleChildren -> {
                singleChildren.setParentId(navigation.getUuid());
                savedChildren.add(singleChildren);
            });
            navigation.setChildren(navigationRepository.saveAllAndFlush(savedChildren));
            navigationRepository.saveAndFlush(navigation);
        }
        return modelMapper.map(navigation, NavigationDto.class);
    }

    public void deleteNavigation(UUID id) {
        System.out.println(id);
        navigationRepository.delete(
                navigationRepository.findByUuid(id)
        );
    }


    public void deleteAllNavigations() {
        navigationRepository.deleteAll();
    }
}
