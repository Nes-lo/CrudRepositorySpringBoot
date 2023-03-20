package com.codingdojo.projectmanager.services;

import com.codingdojo.projectmanager.model.LoginUser;
import com.codingdojo.projectmanager.model.Project;
import com.codingdojo.projectmanager.model.User;
import com.codingdojo.projectmanager.repositories.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;



    public User save(User user, BindingResult result){

     Date birth=user.getBirthDate();
     if (birth==null)
     {
         birth=new Date();
     }

        if(userRepository.findByEmail(user.getEmail()).isPresent()){
            result.rejectValue("email", "Unique", "Existing Email!");
            return null;

        } else if (!Pattern
                .compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^.,&+=])(?=\\S+$).{8,16}$")
                .matcher(user.getPassword()).matches()) {
            result.rejectValue("password", "ValidationError", "The password must have alphanumeric characters, uppercase, lowercase and special character!");
            return null;
        } else if (ChronoUnit.YEARS.between
                (LocalDate.ofInstant(birth.toInstant(), ZoneId.systemDefault()), LocalDate.now())<10) {
            result.rejectValue("birthDate", "Matches", "You must be at least 10 years old to register!");
        } else if(!user.getPassword().equals(user.getConfirmPassword())) {
            result.rejectValue("confirmPassword", "Matches", "The Confirm Password must match Password!");
            return null;
        } else if (!result.hasErrors()) {
            user.setPassword(BCrypt.hashpw(user.getPassword(),BCrypt.gensalt()));
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
        else if(Boolean.FALSE.equals(BCrypt.checkpw(newLogin.getPassword(),user.getPassword()))
        ){
            result.rejectValue("password", "Matches", "Invalid Password!");
            return null;
        }
        return user;
    }
    public List<User> allUsers(){
        return userRepository.findAll();
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAssignedProjects(Project project){
        return null;// userRepository.findAllByProjects(project);
    }

    public List<User> getunAssignedProjects(Project project){
        return null;// userRepository.findByProjectsNotContains(project);
    }

    public User findById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()) {
            return optionalUser.get();
        }else {
            return null;
        }
    }
}
