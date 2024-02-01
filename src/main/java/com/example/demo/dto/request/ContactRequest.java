package com.example.demo.dto.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContactRequest {
    private String firstName;

    private String lastName;

    private Long mobile;

    private Long accountNo;
}

