package com.BankApp.service.authentication;

import com.BankApp.dto.AppResponse;
import com.BankApp.dto.AuthenticationRequest;
import com.BankApp.dto.UserDetailsDto;

public interface UserDetailsServiceImpl {
     AppResponse<?> createAccount(UserDetailsDto userDetailsDto);

    AppResponse<String> loginAccount(AuthenticationRequest request);
}
