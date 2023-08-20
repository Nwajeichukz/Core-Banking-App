package com.BankApp.controller;

import com.BankApp.dto.AppResponse;
import com.BankApp.dto.AuthenticationRequest;
import com.BankApp.dto.UserDetailsDto;
import com.BankApp.service.authentication.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final UserDetailsServiceImpl userDetailsService;

    @GetMapping
    public String getBank(){
        return "welcome too our Bank app";
    }

    @PostMapping("/open_account")
    public ResponseEntity<AppResponse<?>> createAccount(@Valid @RequestBody UserDetailsDto userDetailsDto){
        return ResponseEntity.ok(userDetailsService.createAccount(userDetailsDto));
    }

    @PostMapping("/login")
    public ResponseEntity<AppResponse<String>> loginAccount(@Valid @RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(userDetailsService.loginAccount(request));
    }
}