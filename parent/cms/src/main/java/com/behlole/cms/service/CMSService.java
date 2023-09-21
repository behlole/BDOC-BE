package com.behlole.cms.service;

import com.behlole.cms.dto.CMSDto;
import com.behlole.cms.mappings.CMSRequest;
import com.behlole.cms.models.CMS;
import com.behlole.cms.repository.CMSRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record CMSService(CMSRepository cmsRepository) {
    public void registerCMS(CMSRequest cmsRequest) {
        CMS cms = CMS.builder()
                .firstName(cmsRequest.firstName())
                .lastName(cmsRequest.lastName())
                .build();
        cmsRepository.save(cms);
    }

    public List<CMSDto> getCMS() {
        List<CMS> cms = cmsRepository.findAll();
        return cms.stream().map(this::convertCMSToDto).toList();
    }

    private CMSDto convertCMSToDto(CMS cms) {
        return CMSDto
                .builder()
                .id(cms.getId())
                .firstName(cms.getFirstName())
                .lastName(cms.getLastName())
                .build()
                ;
    }
}
