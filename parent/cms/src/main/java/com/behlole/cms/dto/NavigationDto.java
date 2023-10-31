package com.behlole.cms.dto;

import com.behlole.cms.models.Navigation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class NavigationDto {
    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    private String subtitle;
    @NotBlank
    private String type;
    @NotBlank
    private String icon;
    private String link;
    private List<NavigationDto> children;
}
