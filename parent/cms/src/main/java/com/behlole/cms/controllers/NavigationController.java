package com.behlole.cms.controllers;

import com.behlole.cms.dto.NavigationDto;
import com.behlole.cms.service.NavigationService;
import com.behlole.cms.utilities.ResponseMappings;
import jakarta.validation.Valid;
import jakarta.ws.rs.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;
import java.util.UUID;

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

    @PostMapping("/bulk")
    ResponseEntity<Object> createBulkNavigation(@RequestBody @Valid List<NavigationDto> navigationDtoList) {
        return responseMappings.getSuccessMessage(
                navigationDtoList
                        .stream()
                        .map(
                                navigationDto ->
                                        navigationService.createNavigation(navigationDto))
                        .toList()
        );
    }

    @PutMapping
    ResponseEntity<Object> updateNavigation(
            @RequestBody @Valid NavigationDto data,
            @RequestParam(name = "uuid", required = false) UUID id) {
        if (id != null) {
            navigationService.deleteNavigation(id);
            return responseMappings.getSuccessMessage(navigationService.createNavigation(data));
        }
        return this.createNavigation(data);
    }

    @DeleteMapping("/delete")
    ResponseEntity<Object> deleteNavigation(@RequestParam(required = false) UUID uuid) {
        if (uuid == null) {
            navigationService.deleteAllNavigations();
            return responseMappings.getSuccessMessageWithoutDataAndWithoutMessage();
        } else {
            navigationService.deleteNavigation(uuid);
            return responseMappings.getSuccessMessageWithoutDataAndWithoutMessage();
        }
    }
}
