package com.behlole.doctor.services;

import com.behlole.doctor.dto.EducationDto;
import com.behlole.doctor.dto.ServiceDto;
import com.behlole.doctor.models.ServiceModel;
import com.behlole.doctor.repositories.ServiceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceModelService {
    @Autowired
    ServiceRepository serviceRepository;
    @Autowired
    ModelMapper modelMapper;

    public ServiceDto parseServiceToServiceDto(ServiceModel service) {
        return modelMapper.map(service, ServiceDto.class);
    }

    public List<ServiceDto> convertServiceListToServiceDtoList(List<ServiceModel> serviceModels) {
        return serviceModels.stream().map(this::parseServiceToServiceDto).toList();
    }

    public List<ServiceModel> convertServiceListDtoToServiceModelList(List<ServiceDto> serviceDtos) {
        return serviceDtos.stream().map(this::parseServiceDtoToServiceModel).toList();
    }

    public ServiceModel parseServiceDtoToServiceModel(ServiceDto serviceDto) {
        return modelMapper.map(serviceDto, ServiceModel.class);
    }

    public List<ServiceDto> createService(List<ServiceDto> serviceDtoList) {
        return convertServiceListToServiceDtoList(
                serviceRepository.saveAllAndFlush(
                        convertServiceListDtoToServiceModelList(serviceDtoList)
                )
        );
    }
}
