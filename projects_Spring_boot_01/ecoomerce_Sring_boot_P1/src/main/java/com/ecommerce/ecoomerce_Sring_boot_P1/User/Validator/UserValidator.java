package com.ecommerce.ecoomerce_Sring_boot_P1.User.Validator;

import com.ecommerce.ecoomerce_Sring_boot_P1.User.Entity.DTO.UserRequestDTO;
import com.ecommerce.ecoomerce_Sring_boot_P1.User.Exception.UserValidationException;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Scope("prototype")
public class UserValidator {

    private Map<String,String>error=new HashMap<>();

    public void validateNewUSerData(UserRequestDTO userRequestDTO) {

        checkValidUSerName(userRequestDTO.getUserName());
        checkRole(userRequestDTO.getRole());
        checkValidEmail(userRequestDTO.getEmail());

        if(error.size()<0){
            throw new UserValidationException(error);
        }

    }

    public void checkValidUSerName(String userName){
        if(!userName.matches(".{4,8}")){
            error.put("userName","Username length should be above 4 to 8");
        }else if(!userName.matches("[A-Z,a-z]]")){
            error.put("userName","username should contain character");
        }else if(!userName.matches("[0-9]]")){
            error.put("userName","userName should cointain number");
        }else if(userName.matches("[!@#$%^&*]]")){
            error.put("userName","userName doesnot contain special character");
        }else {
            error.remove("userName");
        }
    }

    public void checkRole(String role){
        if(!role.isEmpty()){
            if(role != "user" && role != "admin"){
                error.put("role","select valid role");
            }else{
                error.remove("role");
            }
        }else{
            error.put("role","select valid Role");
        }
    }

    public void checkValidEmail(String email){
        if(!email.matches("^[A-Za-z0-9+_.-]]+@[A-Za-z0-9,-]+\\.com$]")){
            error.put("email","enter a valid email");
        }else{
            error.remove("email");
        }
    }

    public void validateLoginUSer(UserRequestDTO userRequestDTO) {

        checkValidEmail(userRequestDTO.getEmail());

        if(error.size()<0){
            throw new UserValidationException(error);
        }
    }
}
