package com.ecommerce.ecoomerce_Sring_boot_P1.User.Utils;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class UserUtils {

    public static String genrateOtp(int length){
        SecureRandom random=new SecureRandom();
        StringBuilder otp=new StringBuilder();

        for(int i=0;i<length;i++){
            otp.append(random.nextInt(10));
        }

        return otp.toString();
    }
}
