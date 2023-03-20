package com.codingdojo.services;




import org.mindrot.jbcrypt.BCrypt;



import org.springframework.stereotype.Service;

@Service
public class EncryptServiceImplement implements EncryptService{

    @Override
    public String encryptPassword(String password) {
        return BCrypt.hashpw(password,BCrypt.gensalt());
    }

    @Override
    public Boolean verifyPassword(String originalPassword, String hashPassword) {
        return BCrypt.checkpw(originalPassword,hashPassword);
    }


}
