package com.example.demo.dto.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccountRequest {

    private Long accountNo;

    private String accountHolder ;

    private Double balance;

    private String accountType;
}
