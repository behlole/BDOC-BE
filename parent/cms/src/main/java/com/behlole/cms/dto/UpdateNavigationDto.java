package com.behlole.cms.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class UpdateNavigationDto {
    private UUID uuid;
    private String id;
    private String title;
    private String subtitle;
    private String type;
    private Boolean isParent;
    private String icon;
    private String link;
    private Boolean exactMatch;
    private List<NavigationDto> children;
    private UUID parentId;
}
