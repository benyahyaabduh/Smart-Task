package com.cwa.gedApp.repository;

import com.cwa.gedApp.entity.Project;
import com.cwa.gedApp.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TeamDao extends JpaRepository<Team,Long> {

    boolean existsByName(String name);



}
