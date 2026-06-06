package com.cwa.gedApp.services;

import com.cwa.gedApp.dtos.TaskDto;
import com.cwa.gedApp.entity.Task;
import com.cwa.gedApp.entity.User;
import com.cwa.gedApp.enums.Status;
import com.cwa.gedApp.mapper.TaskMapper;
import com.cwa.gedApp.mapper.UserMapper;
import com.cwa.gedApp.repository.TaskDao;
import com.cwa.gedApp.repository.UserDao;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class TaskServiceImpl implements TaskService{

    private final TaskDao taskDao;
    private final UserDao userDao;
    private final TaskMapper taskMapper;

    public TaskServiceImpl(TaskDao taskDao, UserDao userDao, TaskMapper taskMapper) {
        this.taskDao = taskDao;
        this.userDao = userDao;
        this.taskMapper = taskMapper;
    }


    @Override
    public Task createTask(TaskDto taskDto , Long userId) {
        User user = userDao.findById(userId)
                .orElseThrow(()->new RuntimeException("User not found"));

        Task task = taskMapper.toEntity(taskDto);
        task.setUser(user);
        task.setStatus(task.getStatus() != null ? task.getStatus() : Status.TODO);
        task.setCreatedAt(LocalDateTime.now());

        return taskDao.save(task);
    }

    @Override
    public Task updateTask(Long idTask, TaskDto taskDto, Long userId) {

        //on recupere l'objet et verifier s'il existe ou non

        Task taskUpdate =taskDao.findById(idTask).orElseThrow(()->new RuntimeException("task not found"));

        //on verifier est ce que la tache de cette utilisateur ou non

        if (!taskUpdate.getUser().getId().equals(userId)) {
            throw new RuntimeException("User Unauthorized");
        }

        taskUpdate.setDeadline(taskDto.getDeadline());
        taskUpdate.setTitle(taskDto.getTitle());
        taskUpdate.setDescription(taskDto.getDescription());
        taskUpdate.setStatus(taskDto.getStatus());
        taskUpdate.setPriority(taskDto.getPriority());


        return taskDao.save(taskUpdate);
    }


    public List<Task> findByUserId(Long userId) {

    User user = userDao.findById(userId).orElseThrow(()->new RuntimeException("User not found"));
        return taskDao.findByUserId(user.getId());
    }

    @Override
    public void deleteTask(Long idTask, User user) {
        Task taskDelete =taskDao.findById(idTask).orElseThrow(()->new RuntimeException("Task not found"));
        if (!taskDelete.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("User Unauthorized");
        }
        taskDao.delete(taskDelete);

    }
}
