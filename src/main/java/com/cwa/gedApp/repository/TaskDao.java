package com.cwa.gedApp.repository;

import com.cwa.gedApp.entity.Task;
import com.cwa.gedApp.entity.User;
import com.cwa.gedApp.enums.Priority;
import com.cwa.gedApp.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskDao extends JpaRepository<Task,Long> {

    List<Task> findByUser(User user);

    List<Task> findByUserAndStatus(User user, Status status);

    List<Task> findByUserAndPriority(User user, Priority priority);
    List<Task> findByUserId (Long userId);


    Long id(Long id);
}
