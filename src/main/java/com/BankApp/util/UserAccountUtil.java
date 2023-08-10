package com.BankApp.util;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserAccountUtil {

    public static String createAccountNumber(){
        Random random = new Random();
        String tenDigitNumber;

        long randomNumber = Math.abs(random.nextLong());
        String randomString = Long.toString(randomNumber);
        tenDigitNumber = randomString.substring(0, 10);

        return tenDigitNumber;
    }


}
