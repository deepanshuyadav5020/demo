package com.example.demo.dto.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContactResponse {
    private Long id;

    private String firstName;

    private String lastName;

    private Long mobile;

    private Long accountNo;
}

