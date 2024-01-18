package com.BankApp.service.authentication;

import com.BankApp.dto.response.AppResponse;
import com.BankApp.dto.AuthenticationRequest;
import com.BankApp.dto.UserDetailsDto;
import com.BankApp.entity.User;

import java.util.List;

public interface UserDetailsServiceImpl {
     AppResponse<?> createAccount(UserDetailsDto userDetailsDto);

    AppResponse<?> loginAccount(AuthenticationRequest request);

    List<User> getAllUsers();
}
