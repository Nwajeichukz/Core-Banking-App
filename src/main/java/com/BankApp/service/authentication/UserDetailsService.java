package com.BankApp.service.authentication;

import com.BankApp.dto.AppResponse;
import com.BankApp.dto.AuthenticationRequest;
import com.BankApp.dto.UserDetailsDto;
import com.BankApp.entity.Roles;
import com.BankApp.entity.Wallet;
import com.BankApp.repository.RoleRepository;
import com.BankApp.repository.UserDetailsRepository;
import com.BankApp.repository.WalletRepository;
import com.BankApp.service.JwtService;
import com.BankApp.service.MyUserDetailsService;
import com.BankApp.util.UserAccountUtil;
import com.BankApp.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserDetailsService implements UserDetailsServiceImpl {
    private final UserDetailsRepository userDetailsRepository;

    private final RoleRepository roleRepository;

    private final WalletRepository walletRepository;

    private final MyUserDetailsService myUserDetailsService;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    //Todo 1: set up the todo list.
    //Todo 2: Deposition of funds Api.
    //Todo 3: transfer of funds.
    //Todo 4: secondary export the pictures.

    @Override
    public AppResponse<?> createAccount(UserDetailsDto userDetailsDto) {
        int zero = 0;
        boolean ninCheck = userDetailsRepository.existsByNin(userDetailsDto.getNin());
         if (ninCheck){
            if (checkSavings(userDetailsDto).contains("savings"))
               return AppResponse.<String>builder().status(-1).message("account already exists").build();
        }

        if (!userDetailsDto.getPassword().equals(userDetailsDto.getConfirmPassword()))
            return AppResponse.<String>builder().status(-1).message("password do not correspond").build();

        Roles role = roleRepository.findByName("USER").orElseThrow();


        User user = User.builder().lastname(userDetailsDto.getSurname())
                                                .phoneNumber(zero + userDetailsDto.getPhoneNumber())
                                                .firstname(userDetailsDto.getFirstname())
                                                .bvn_Pin(userDetailsDto.getBvn_Pin())
                                                .passport(userDetailsDto.getPassport())
                                                .dob(userDetailsDto.getDob())
                                                .nin(userDetailsDto.getNin())
                                                .password(passwordEncoder.encode(userDetailsDto.getPassport()))
                                                .email(userDetailsDto.getEmail())
                                                .accountType(userDetailsDto.getAccountType())
                                                .roles(role)
                                                .wallet(dtoToWallet(userDetailsDto))
                                                .build();
        userDetailsRepository.save(user);


        return new AppResponse<>(0, "user successfully saved", Map.of(
                "id", user.getId(),
                "firstname" , user.getFirstname(),
                "lastname" , user.getLastname(),
                "dob" , user.getDob(),
                "email" , user.getEmail(),
                "accountType", user.getAccountType(),
                "nin" , user.getNin(),
                "bvn" , user.getBvn_Pin(),
                "accountNumber", user.getWallet().getAccountNumber()
        ));
    }

    @Override
    public AppResponse<String> loginAccount(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        var user = myUserDetailsService.loadUserByUsername(request.getEmail());

        var jwtToken = jwtService.generateToken(user);

        return  new AppResponse<>(0,"Successfully logged in", jwtToken);
    }



    public Wallet dtoToWallet(UserDetailsDto userDetailsDto){
        String accountNums = UserAccountUtil.createAccountNumber();

        Wallet wallet = Wallet.builder()
                .accountBal(userDetailsDto.getDeposit())
                .accountNumber(accountNums)
                .build();
        walletRepository.save(wallet);

        return wallet;
    }


    public List<String> checkSavings(UserDetailsDto userDetailsDto){
        List<User> users = userDetailsRepository.findByNinContaining(userDetailsDto.getNin());

         List<String> allAccountType = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getAccountType().equals("savings")) allAccountType.add("savings");
            if (users.get(i).getAccountType().equals("current")) allAccountType.add("current");
            if (users.get(i).getAccountType().equals("fixed_deposit")) allAccountType.add("fixed_deposit");
        }

        return allAccountType;
    }
}