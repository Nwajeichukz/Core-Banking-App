package com.BankApp.controller;

import com.BankApp.dto.AppResponse;
import com.BankApp.dto.UserDetailsDto;
import com.BankApp.service.UserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/bank")
@RequiredArgsConstructor
public class BankController {

    private final UserDetailsService userDetailsService;

    @GetMapping
    public String getBank(){
        return "welcome too our Bank app";
    }

    @PostMapping("/open_account")
    public ResponseEntity<AppResponse<String>> createAccount(@Valid @RequestBody UserDetailsDto userDetailsDto){
        return ResponseEntity.ok(userDetailsService.createAccount(userDetailsDto));
    }
}
