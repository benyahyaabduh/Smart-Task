package com.cwa.gedApp.services;

import com.cwa.gedApp.entity.Task;
import com.cwa.gedApp.entity.User;
import com.cwa.gedApp.enums.Priority;
import com.cwa.gedApp.enums.Status;

import java.awt.desktop.UserSessionEvent;
import java.util.List;

public interface TaskService {

    Task createTask(Task task,User user);
    List<Task> getUserTasks(User user);

    Task updateTask(Long idTask,Task task,User user);
    void deleteTask (Long idTask,User user);


}
