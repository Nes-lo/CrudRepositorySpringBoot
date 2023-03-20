package com.codingdojo.services;

public interface EncryptService {
   /***
    * Let us to encrypt the password
    * @Param password
    * @return
    *
   */
    String encryptPassword(String password);

    /***
     * Verify if the original password and has password are the same
     * @param originalPassword
     * @param hashPassword
     * @return
     */
    Boolean verifyPassword(String originalPassword, String hashPassword);
}
