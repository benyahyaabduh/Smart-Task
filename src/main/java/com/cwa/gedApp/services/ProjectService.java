package com.cwa.gedApp.services;

import com.cwa.gedApp.entity.Project;

public interface ProjectService {

    public Project createProject(Project project,Long teamId);
    public Project getProjectById(Long id);
    public java.util.List<Project> getAllProjects();
    public void deleteProject(Long id);
}
