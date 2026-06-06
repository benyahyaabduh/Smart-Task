package com.cwa.gedApp.controller;

import com.cwa.gedApp.entity.Project;
import com.cwa.gedApp.services.ProjectService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Api/Project")
public class ProjectController {

    final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/CreateProject/{teamId}")
    Project createProject(@RequestBody Project project,@PathVariable Long teamId){

            return projectService.createProject(project,teamId);
    }

    @GetMapping("/GetProjectById/{id}")
    Project getProjectById(@PathVariable Long id){

        return projectService.getProjectById(id);
    }

    @DeleteMapping("/DeleteProjectById/{id}")
    public void deleteProject(@PathVariable Long id){

         projectService.deleteProject(id);
    }


}
