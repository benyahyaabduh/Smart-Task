package com.cwa.gedApp.services;

import com.cwa.gedApp.dtos.TaskDto;
import com.cwa.gedApp.entity.Task;
import com.cwa.gedApp.entity.User;
import com.cwa.gedApp.enums.Priority;
import com.cwa.gedApp.enums.Status;

import java.awt.desktop.UserSessionEvent;
import java.util.List;

public interface TaskService {

    Task createTask(TaskDto taskDto,Long userId);
    public List<Task> findByUserId(Long userId);

    Task updateTask(Long idTask,TaskDto taskDto,Long userId);
    void deleteTask (Long idTask,User user);


}
