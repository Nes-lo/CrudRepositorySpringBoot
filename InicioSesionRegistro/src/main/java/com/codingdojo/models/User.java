package com.codingdojo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message="¡Se requiere Username!")
    @Size(min=3, max=30, message="Username debe tener entre 3 y 30 caracteres")
    private String userName;

    @Column(unique = true)
    @NotEmpty(message="¡Se requiere Email!")
    @Email(message="¡Ingrese un Email válido!")
    private String email;

    @NotNull(message="¡Se requiere fecha de nacimiento!")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthDate;

    @NotEmpty(message="¡Se requiere contraseña!")
    @Size(min=8, max=200, message="Password must have at least 8 characters")
    private String password;

    @Transient
    @NotEmpty(message="Confirm Password is required!")
    @Size(min=8, max=200, message="Confirm Password Password must have at least 8 characters")
    private String confirm;





}