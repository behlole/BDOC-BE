package com.behlole.cms.controllers;

import com.behlole.cms.dto.CMSDto;
import com.behlole.cms.mappings.CMSRequest;
import com.behlole.cms.service.CMSService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/cms")
public record CMSController(CMSService cmsService) {
    @PostMapping
    public CMSDto registerCMS(@RequestBody CMSRequest cmsRequest) {
        return cmsService.registerCMS(cmsRequest);
    }

    @GetMapping
    public List<CMSDto> getCMSData() {
        return cmsService.getCMS();
    }
}
