package com.BankApp.service;

import com.BankApp.dto.AppResponse;
import com.BankApp.dto.UserDetailsDto;
import com.BankApp.repository.UserDetailsRepository;
import com.BankApp.util.UserAccountUtil;
import com.BankApp.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserDetailsService {
    private final UserDetailsRepository userDetailsRepository;


    //Todo 1:
    //Todo 2: import the pictures.
    //Todo 3: export the pictures.

    public AppResponse<String> createAccount(UserDetailsDto userDetailsDto) {
        int zero = 0;
        boolean ninCheck = userDetailsRepository.existsByNin(userDetailsDto.getNin());

        if (ninCheck) return new AppResponse<>(-1, "you have an existing account with us");

        String accountNums = UserAccountUtil.createAccountNumber();

        User user = User.builder().surname(userDetailsDto.getSurname())
                                                .phoneNumber(zero + userDetailsDto.getPhoneNumber())
                                                .firstname(userDetailsDto.getFirstname())
                                                .bvn_Pin(userDetailsDto.getBvn_Pin())
                                                .passport(userDetailsDto.getPassport())
                                                .email(userDetailsDto.getEmail())
                                                .dob(userDetailsDto.getDob())
                                                .nin(userDetailsDto.getNin())
                                                .accountBal(userDetailsDto.getDeposit())
                                                .accountNumber(accountNums)
                                                .build();

        userDetailsRepository.save(user);

        return AppResponse.<String>builder()
                .status(0)
                .message("Successfully saved")
                .build();
    }
}
