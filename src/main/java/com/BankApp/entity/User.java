package com.BankApp.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;


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

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "user_email", nullable = false)
    private String email;

    @Column(name = "dob", nullable = false)
    private String dob;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "nin", nullable = false)
    private String nin;

    @Column(name = "bvn", nullable = false)
    private String bvn_Pin;

    @Column(name = "passport", nullable = false)
    private String passport;


    @Column(name = "account_type", nullable = false)
    private String accountType;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_fk", referencedColumnName = "id")
    private Roles roles;

    @OneToOne
    @JoinColumn(name = "wallet_fk", referencedColumnName = "id")
    private Wallet wallet;

}