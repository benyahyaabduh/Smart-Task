package com.cwa.gedApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "project")
@Builder
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50, nullable = false)
    @NotBlank(message = "Le nom de projet est obligatoire")
    @Size(max = 50, message = "Le nom ne doit pas dépasser 50 caractères") // <-- ICI
    private String name;

    @Column(length = 255)
    private String description;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "team_id")
    @JsonIgnoreProperties({"projects", "members"})
    private Team team;


    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"project", "user"})
    private List<Task> taskList;


    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public Long getId() {
        return id;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public String getName() {
        return name;
    }

    public Team getTeam() {
        return team;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getDescription() {
        return description;
    }
}
