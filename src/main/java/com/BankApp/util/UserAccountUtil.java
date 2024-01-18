package com.BankApp.util;

import com.BankApp.dto.UserDetailsDto;
import com.BankApp.entity.Wallet;
import com.BankApp.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequiredArgsConstructor
public class UserAccountUtil {


    public static String createAccountNumber(){
        Random random = new Random();
        String tenDigitNumber;

        long randomNumber = Math.abs(random.nextLong());
        String randomString = Long.toString(randomNumber);
        tenDigitNumber = randomString.substring(0, 10);

        return tenDigitNumber;
    }

    public static boolean checkBalanceIfSufficient(long accountBalance, long amountToSend){
        return accountBalance > amountToSend;
    }


    public static String context(){
        String sam = SecurityContextHolder.getContext().getAuthentication().getName();
        return sam;

    }

}
