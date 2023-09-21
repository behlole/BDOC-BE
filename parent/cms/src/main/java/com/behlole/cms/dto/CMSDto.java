package com.behlole.cms.dto;

import jakarta.persistence.Entity;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CMSDto {
    private Long id;
    private String firstName;
    private String lastName;
}
