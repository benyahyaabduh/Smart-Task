package com.cwa.gedApp.services;

import com.cwa.gedApp.entity.Task;
import com.cwa.gedApp.entity.Team;
import com.cwa.gedApp.entity.User;
import com.cwa.gedApp.enums.Status;
import com.cwa.gedApp.repository.TeamDao;
import com.cwa.gedApp.repository.UserDao;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
public class TeamServiceImpl implements TeamService{

    public final TeamDao teamDao;
    public final UserDao userDao;

    public TeamServiceImpl(TeamDao teamDao, UserDao userDao) {
        this.teamDao = teamDao;
        this.userDao = userDao;
    }


    @Override
    public Team createTeam(Team team, Long userId) {

        if (teamDao.existsByName(team.getName())) {
            throw new RuntimeException("Une équipe avec ce nom existe déjà !");
        }

        return teamDao.save(team);    }

    @Override
    public Team addUserToTeam(Long teamId, Long userId) {
        Team team = teamDao.findById(teamId)
                .orElseThrow(() -> new RuntimeException("Équipe introuvable"));

        User user = userDao.findById(userId)
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));

        user.setTeam(team);
        userDao.save(user);
        return team;
    }






    @Override
    public Team getTeamById(Long id) {
        return teamDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Équipe introuvable"));
    }
}
