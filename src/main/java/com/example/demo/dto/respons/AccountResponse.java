package com.example.demo.dto.respons;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccountResponse {
    private Long id;

    private Long accountNo;

    private String accountHolder ;

    private Double balance;

    private String accountType;
}
