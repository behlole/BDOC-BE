package com.behlole.cms.service;

import com.behlole.cms.dto.CMSDto;
import com.behlole.cms.mappings.CMSRequest;
import com.behlole.cms.models.CMS;
import com.behlole.cms.repository.CMSRepository;
import jakarta.ws.rs.core.NoContentException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public record CMSService(CMSRepository cmsRepository) {
    public CMSDto registerCMS(CMSRequest cmsRequest) {
        CMS cms = CMS.builder()
                .name(cmsRequest.getName())
                .content(cmsRequest.getContent())
                .createdAt(new Date())
                .build();
        cmsRepository.saveAndFlush(cms);
        return convertCMSToDto(cms);
    }

    public List<CMSDto> getCMS() {
        List<CMS> cms = cmsRepository.findAll();
        return cms.stream().map(this::convertCMSToDto).toList();
    }

    private CMSDto convertCMSToDto(CMS cms) {
        return CMSDto
                .builder()
                .id(cms.getId())
                .name(cms.getName())
                .content(cms.getContent())
                .build()
                ;
    }

    public CMSDto getSingleCMS(String name) throws NoContentException {
        CMS cms = cmsRepository.findCMSByName(name);
        if (cms == null) {
            throw new NoContentException("No Content Found");
        }
        return convertCMSToDto(cmsRepository.findCMSByName(name));
    }
}
