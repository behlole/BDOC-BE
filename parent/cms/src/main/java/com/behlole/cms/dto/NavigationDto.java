package com.behlole.cms.dto;

import jakarta.validation.constraints.NotBlank;
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
    private UUID parentId;
}
