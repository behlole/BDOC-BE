package com.behlole.authentication.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @SequenceGenerator(
            name = "authentication_id_sequence",
            sequenceName = "authentication_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "authentication_id_sequence"
    )
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
