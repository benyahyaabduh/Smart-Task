package com.cwa.gedApp.repository;

import com.cwa.gedApp.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectDao extends JpaRepository<Project,Long> {
    boolean existsByName(String name);
}
