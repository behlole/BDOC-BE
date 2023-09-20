package com.behlole.cms.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CMS {
    @Id
    @SequenceGenerator(
            name = "cms_id_sequence",
            sequenceName = "cms_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cms_id_sequence"
    )
    public long id;
    public String firstName;
    public String lastName;
}
