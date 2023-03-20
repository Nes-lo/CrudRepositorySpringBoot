package com.codingdojo.projectmanager.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "{NotEmpty.message}")
    @Size(min=5, max = 30, message = "{Size.message}")
    private String userName;
    @NotEmpty(message = "{NotEmpty.message}")
    @Email(message = "{Email.message}")
    @Column(unique = true)
    private String email;
    @NotNull(message = "{NotEmpty.message}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
    @NotEmpty(message = "{NotEmpty.message}")
    @Size(min = 8, max = 200, message = "{Size.pw}")
    private String password;
    @NotEmpty(message = "{NotEmpty.message}")
    @Transient
    private String confirmPassword;
    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;


    @OneToMany(mappedBy = "manager",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Project> managedProjects;
   //  @JsonManagedReference(value = "hobbies-json")//Objeto de Usuario SI se vea la lista de hobbies
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="project_members",
            joinColumns=@JoinColumn(name="user_id"),
            inverseJoinColumns=@JoinColumn(name="project_id")
    )
    private List<Project> projectMembers;


    @OneToMany(mappedBy = "member",fetch = FetchType.LAZY)
    private List<Task> tasks;

    @PrePersist
    @DateTimeFormat(pattern="yyyy-MM-dd")
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    @DateTimeFormat(pattern="yyyy-MM-dd")
    protected void onUpdate(){
        this.updatedAt = new Date();
    }


}
