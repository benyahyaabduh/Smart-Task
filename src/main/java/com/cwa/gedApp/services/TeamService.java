package com.cwa.gedApp.services;

import com.cwa.gedApp.entity.Team;

public interface TeamService {

    public Team createTeam(Team team,Long userId);
    public Team getTeamById (Long id);
    public Team addUserToTeam(Long teamId, Long userId);

}
