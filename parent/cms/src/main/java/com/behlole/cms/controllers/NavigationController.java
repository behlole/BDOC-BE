package com.behlole.cms.controllers;

import com.behlole.cms.dto.NavigationDto;
import com.behlole.cms.service.NavigationService;
import com.behlole.cms.utilities.ResponseMappings;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api/v1/cms/navigation")
public class NavigationController {
    @Autowired
    NavigationService navigationService;
    @Autowired
    ResponseMappings responseMappings;

    @GetMapping
    public ResponseEntity<Object> getNavigation() {
        return responseMappings.getSuccessMessage(navigationService.getNavigationList());
    }

    @PostMapping
    ResponseEntity<Object> createNavigation(@RequestBody @Valid NavigationDto navigationDto) {
        return responseMappings.getSuccessMessage(navigationService.createNavigation(navigationDto));
    }

    @PostMapping("/update")
    ResponseEntity<Object> updateNavigation(
            @RequestBody @Valid NavigationDto navigationDto,
            @RequestParam(name = "id") Long id) {
        navigationService.deleteNavigation(id);
        return responseMappings.getSuccessMessage(navigationService.createNavigation(navigationDto));
    }

    @DeleteMapping("/delete")
    ResponseEntity<Object> deleteNavigation() {
        navigationService.deleteAllNavigations();
        return responseMappings.getSuccessMessageWithoutDataAndWithoutMessage();
    }

}
