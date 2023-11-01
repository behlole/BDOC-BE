package com.behlole.cms.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

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
    private UUID uuid;

    private String id;
    private String title;
    private String subtitle;
    private String type;
    private String icon;
    private Boolean exactMatch;
    @Column(nullable = true)
    private Boolean isParent = false;
    @Column(nullable = true)
    private String link;
    @OneToMany(cascade = CascadeType.REMOVE)
    @Column(nullable = true)
    private List<Navigation> children;

    @ManyToOne(fetch = FetchType.LAZY)
    private Navigation navigation;
}
