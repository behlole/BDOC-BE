package com.behlole.doctor.services;

import com.behlole.doctor.dto.ServiceDto;
import com.behlole.doctor.models.ServiceModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceModelService {
    public ServiceDto parseServiceToServiceDto(ServiceModel service) {
        ServiceDto serviceDto = new ServiceDto();
        serviceDto.setServiceName(service.getServiceName());
        serviceDto.setId(service.getId());
        return serviceDto;
    }

    public List<ServiceDto> convertServiceListToServiceDtoList(List<ServiceModel> serviceModels) {
        return serviceModels.stream().map(this::parseServiceToServiceDto).toList();
    }

    public List<ServiceModel> convertServiceListDtoToServiceModelList(List<ServiceDto> serviceDtos) {
        return serviceDtos.stream().map(this::parseServiceDtoToServiceModel).toList();
    }

    public ServiceModel parseServiceDtoToServiceModel(ServiceDto serviceDto) {
        ServiceModel serviceModel = new ServiceModel();
        serviceModel.setServiceName(serviceDto.getServiceName());
        serviceModel.setId(serviceDto.getId());
        return serviceModel;
    }
}
