package com.codingdojo.services;

import com.codingdojo.models.LoginUser;
import com.codingdojo.models.User;
import com.codingdojo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.regex.Pattern;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    EncryptService encryptService;
    //Valida que el password cumpla con los requisitos establecidos
    private static final Pattern PASSWORD_PATTERN=Pattern
            .compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^.,&+=])(?=\\S+$).{8,16}$");
    
    public User findById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public User saveUser(User user, BindingResult result){

        if(userRepository.findByEmail(user.getEmail()).isPresent()){
                      result.rejectValue("email", "Matches", "Existing Email!");
            return null;

        } else if (!PASSWORD_PATTERN.matcher(user.getPassword()).matches()) {
            result.rejectValue("password", "ValidationError", "The password must have alphanumeric characters, uppercase, lowercase and special character!");
            return null;            
        } else if (ChronoUnit.YEARS.between
                (LocalDate.ofInstant(user.getBirthDate().toInstant(), ZoneId.systemDefault()), LocalDate.now())<10) {
            result.rejectValue("birthDate", "Matches", "You must be at least 10 years old to register!");
        } else if(!user.getPassword().equals(user.getConfirm())) {
            result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
        return null;
        } else if (!result.hasErrors()) {
            user.setPassword(encryptService.encryptPassword(user.getPassword()));
            return userRepository.save(user);
        }
        return null;

    }
    public User login(LoginUser newLogin, BindingResult result){

        User user=userRepository.findByEmail(newLogin.getEmail()).orElse(null);
        if(user==null) {
            result.rejectValue("email", "Matches", "Invalid Email!");
            return null;
        }
        else if(Boolean.FALSE.equals(encryptService.verifyPassword(newLogin.getPassword(), user.getPassword()
               ))){
            result.rejectValue("password", "Matches", "Invalid Password!");
            return null;
        }
        return user;
    }

}
