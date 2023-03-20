package com.codingdojo.projectmanager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String projectName;
    @NotEmpty
    private String projectDescription;

    @NotNull
    @Future
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dueDate;


    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    //@JsonIgnore //Me ignora el regresar ese dato
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    //@JsonBackReference(value="salon-json") //Objeto de Usuario NO va a visualizar el salón
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_manager_id")
    private User manager;
   /// @JsonBackReference(value = "hobbies-json")
    @ManyToMany(mappedBy = "projectMembers")
    private List<User> users;

    @Column(updatable=false)
    @OneToMany(mappedBy = "projectTasks",fetch = FetchType.LAZY)
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
