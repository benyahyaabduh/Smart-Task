package com.cwa.gedApp.controller;

import com.cwa.gedApp.entity.Task;
import com.cwa.gedApp.entity.User;
import com.cwa.gedApp.repository.UserDao;
import com.cwa.gedApp.services.TaskService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Api/Task")
public class TaskController {


    private TaskService taskService;

    private final UserDao userDao;

    public TaskController(UserDao userDao) {
        this.userDao = userDao;
    }


    @GetMapping("/GetTasks")
    List<Task> getUserTasks (@RequestBody User user){

        return taskService.getUserTasks(user);
    }

    @PostMapping("/CreateTask")
    Task createTask (@RequestBody Task task,@PathVariable Long idUser){

        User user =userDao.findById(idUser)
                .orElseThrow(()->new RuntimeException("User not found"));
        return taskService.createTask(task,user);

    }

}
