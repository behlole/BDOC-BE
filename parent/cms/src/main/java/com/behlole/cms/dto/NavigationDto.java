package com.behlole.cms.dto;

import com.behlole.cms.models.Navigation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class NavigationDto {
    private UUID uuid;
    private String id;
    @NotBlank
    private String title;
    private String subtitle;
    @NotBlank
    private String type;
    private Boolean isParent;
    @NotBlank
    private String icon;
    private String link;
    private Boolean exactMatch;
    private List<NavigationDto> children;
}
