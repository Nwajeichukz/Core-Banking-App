package com.BankApp.dto;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class UserDetailsDto {
    //Todo 1: a user can only create 2 accounts which is savings and current with same details
    //Todo 2: account type should only be savings / current
    @NotEmpty(message = "firstname cant be blank")
    private String firstname;

    @NotEmpty(message = "surname cant be blank")
    private String surname;

    @javax.validation.constraints.Pattern(regexp = "(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-([0-9]{4})", message = "wrong date format, expected format DD-MM-YEAR")
    private String dob;

    @javax.validation.constraints.Pattern(regexp = "(\\d{3})-(\\d{4})-(\\d{4})", message = "wrong phone format, format should be 000-0000-0000  ")
    private String phoneNumber;

    @javax.validation.constraints.Pattern(regexp = "(\\w+@)(\\w+\\.com)", message = "wrong email format")
    private String email;

    @Size(min = 11, max = 11, message = "nin pin must be 11 digits")
    private String nin;

    @Size(min = 11, max = 11, message = "bvn pin must be 11 digits")
    private String bvn_Pin;

    @NotEmpty(message = "password cant be blank")
    private String passport;

    @NotNull(message = "a deposit most be made for the registration too be complete")
    private Long deposit;

}
