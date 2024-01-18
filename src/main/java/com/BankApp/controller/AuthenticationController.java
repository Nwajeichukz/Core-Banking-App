package com.BankApp.controller;

import com.BankApp.dto.response.AppResponse;
import com.BankApp.dto.AuthenticationRequest;
import com.BankApp.dto.UserDetailsDto;
import com.BankApp.entity.User;
import com.BankApp.service.authentication.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final UserDetailsServiceImpl userDetailsService;

    @GetMapping
    public String getBank(){
        return "welcome too our Bank app";
    }

    @PostMapping("/create-account")
    public ResponseEntity<AppResponse<?>> createAccount(@Valid @RequestBody UserDetailsDto userDetailsDto){
        return ResponseEntity.ok(userDetailsService.createAccount(userDetailsDto));
    }

    @PostMapping("/sign-in")
    public ResponseEntity<AppResponse<?>> loginAccount(@Valid @RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(userDetailsService.loginAccount(request));
    }

    @GetMapping("/get-users")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userDetailsService.getAllUsers());
    }
}