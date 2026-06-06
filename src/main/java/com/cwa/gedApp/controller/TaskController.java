package com.cwa.gedApp.controller;

import com.cwa.gedApp.dtos.TaskDto;
import com.cwa.gedApp.dtos.UserDto;
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


    private final TaskService taskService;

    private final UserDao userDao;

    public TaskController(TaskService taskService, UserDao userDao) {
        this.taskService = taskService;
        this.userDao = userDao;
    }


    @GetMapping("/GetTasks/{userId}")
    List<Task> findByUserId (@PathVariable Long userId){

        return taskService.findByUserId(userId);
    }

    @DeleteMapping("/DeleteUser/{id}")
    void deleteTaskById (@PathVariable Long id,@RequestBody User user){
        taskService.deleteTask(id , user);

    }

    @PostMapping("/CreateTask/{userId}")
    Task createTask (@RequestBody TaskDto taskDto, @PathVariable Long userId){

        User user =userDao.findById(userId)
                .orElseThrow(()->new RuntimeException("User not found"));

        return taskService.createTask(taskDto,userId);

    }

    Task updateTask (Long idTask, TaskDto taskDto, Long userId){

        return null;
    }






}
