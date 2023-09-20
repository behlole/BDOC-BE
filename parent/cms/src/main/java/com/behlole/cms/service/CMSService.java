package com.behlole.cms.service;

import com.behlole.cms.mappings.CMSRequest;
import com.behlole.cms.models.CMS;
import com.behlole.cms.repository.CMSRepository;
import org.springframework.stereotype.Service;

@Service
public record CMSService(CMSRepository cmsRepository) {
    public void registerCMS(CMSRequest cmsRequest) {
        CMS cms = CMS.builder()
                .firstName(cmsRequest.firstName())
                .lastName(cmsRequest.lastName())
                .build();
        cmsRepository.save(cms);
    }
}
