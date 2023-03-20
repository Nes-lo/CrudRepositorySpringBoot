package com.codingdojo.projectmanager.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@NoArgsConstructor
@Data


public class LoginUser {

    @Email
    @NotEmpty
    private String email;
    @NotEmpty
    @Size(min = 8, max = 200)
    private String password;
}
