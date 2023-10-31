package com.behlole.cms.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Navigation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String subtitle;
    private String type;
    private String icon;
    @Column(nullable = true)
    private String link;
    @OneToMany(cascade = CascadeType.REMOVE)
    @Column(nullable = true)
    private List<Navigation> children;
}
