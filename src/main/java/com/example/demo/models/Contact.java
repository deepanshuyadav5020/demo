package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;

@Table
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private Long mobile;

    private Long accountNo;
}
