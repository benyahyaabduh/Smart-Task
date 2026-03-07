package com.cwa.gedApp.services;

import com.cwa.gedApp.entity.Task;
import com.cwa.gedApp.entity.User;
import com.cwa.gedApp.enums.Status;
import com.cwa.gedApp.repository.TaskDao;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskServiceImpl implements TaskService{

    private final TaskDao taskDao;

    public TaskServiceImpl(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @Override
    public Task createTask(Task task, User user) {
        task.setUser(user);
        if (task.getStatus()==null){
            task.setStatus(Status.TODO);
        }
        return taskDao.save(task);
    }

    @Override
    public Task updateTask(Long idTask, Task task, User user) {

        //on recupere l'objet et verifier s'il existe ou non

        Task taskUpdate =taskDao.findById(idTask).orElseThrow(()->new RuntimeException("task not found"));

        //on verifier est ce que la tache de cette utilisateur ou non

        if (taskUpdate.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("User Unauthorized");
        }

        taskUpdate.setDeadline(task.getDeadline());
        taskUpdate.setTitle(task.getTitle());
        taskUpdate.setDescription(task.getDescription());
        taskUpdate.setStatus(task.getStatus());
        taskUpdate.setPriority(task.getPriority());


        return taskDao.save(taskUpdate);
    }


    @Override
    public List<Task> getUserTasks(User user) {
        return taskDao.findByUser(user);
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
