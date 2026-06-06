package com.cwa.gedApp.services;

import com.cwa.gedApp.entity.Project;
import com.cwa.gedApp.entity.Team;
import com.cwa.gedApp.repository.ProjectDao;
import com.cwa.gedApp.repository.TeamDao;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
public class ProjectServiceImpl implements ProjectService{

    final ProjectDao projectDao;
    final TeamDao teamDao;

    public ProjectServiceImpl(ProjectDao projectDao, TeamDao teamDao) {
        this.projectDao = projectDao;
        this.teamDao = teamDao;
    }

    @Override
    public Project createProject(Project project, Long teamId) {
        Team team = teamDao.findById(teamId)
                .orElseThrow(()->new RuntimeException("Equipe Introuvable, impossible de creer projet"));

        project.setTeam(team);
        project.setCreatedAt(LocalDateTime.now());
        return projectDao.save(project);
    }


    @Override
    public Project getProjectById(Long id) {
        return projectDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Projet introuvable avec l'id "+id));
    }

    @Override
    public java.util.List<Project> getAllProjects() {
        return projectDao.findAll();
    }

    @Override
    public void deleteProject(Long id) {
        Project project = projectDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Projet introuvable avec l'id "+id));

        projectDao.delete(project);
    }
}
