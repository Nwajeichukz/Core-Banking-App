package com.BankApp.entity;


import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "USER_DETAILS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "dob", nullable = false)
    private String dob;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "user_email", nullable = false)
    private String email;

    @Column(name = "nin", nullable = false)
    private String nin;

    @Column(name = "bvn", nullable = false)
    private String bvn_Pin;

    @Column(name = "passport", nullable = false)
    private String passport;

    @Column(name = "accountBal", nullable = false)
    private long accountBal;

    @Column(name = "account_number", nullable = false)
    private String accountNumber;

}
