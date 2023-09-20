package com.behlole.cms.controllers;

import com.behlole.cms.mappings.CMSRequest;
import com.behlole.cms.service.CMSService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/cms")
public record CMSController(CMSService cmsService) {
    @PostMapping
    public void registerCustomer(@RequestBody CMSRequest cmsRequest) {
        cmsService.registerCMS(cmsRequest);
        log.info("New Customer Registration {}", cmsRequest);
    }
}
