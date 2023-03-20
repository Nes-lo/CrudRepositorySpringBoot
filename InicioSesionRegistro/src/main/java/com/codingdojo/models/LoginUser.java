package com.codingdojo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUser {

    @NotEmpty(message="Email is required!")
    @Email(message="Please enter a valid email!")
    private String email;
    @NotEmpty(message="Password is required!")
    @Size(min=8, max=128, message="Password must be between 8 and 128 characters")
    private String password;



}