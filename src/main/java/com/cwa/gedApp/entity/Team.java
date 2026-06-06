package com.cwa.gedApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "team")
@AllArgsConstructor
@NoArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    @Column(length = 20)
    @NotBlank(message = "Le nom d'équipe est obligatoire")
    private String name;



    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"team", "taskList"}) // Évite les boucles infinies en JSON
    private List<User> members;


    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"team"})
    private List<Project> projects;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<User> getMembers() {
        return members;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

}
