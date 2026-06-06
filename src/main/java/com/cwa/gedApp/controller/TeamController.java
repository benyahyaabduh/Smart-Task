package com.cwa.gedApp.controller;

import com.cwa.gedApp.entity.Team;
import com.cwa.gedApp.repository.TeamDao;
import com.cwa.gedApp.services.TeamService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Api/Team")
public class TeamController {

    final TeamService teamService;
    final TeamDao teamDao;

    public TeamController(TeamService teamService, TeamDao teamDao) {
        this.teamService = teamService;
        this.teamDao = teamDao;
    }

    @PostMapping("/CreateTeam/{userId}")
    Team createTeam (Team team,@PathVariable Long userId){
        return teamService.createTeam(team,userId);
    }

    @GetMapping("/GetTeamById/{teamId}")

    Team getTeambyId (@PathVariable Long teamId){
        return teamService.getTeamById(teamId);
    }



    @PostMapping("/AddUserToTeam/{teamId}/{userId}")
    Team addUserToTeam(@PathVariable Long teamId,@PathVariable Long userId){

        return teamService.addUserToTeam(teamId,userId);
 }

}
