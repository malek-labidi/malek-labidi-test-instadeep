package tn.esprit.Service;

import tn.esprit.Entity.TaskEntity;

import java.util.List;

public interface ITaskService {
    TaskEntity addTask(TaskEntity task);
    TaskEntity assignCategoryToTask(Long id, String category);
    TaskEntity removeCategoryFromTask(Long id, String category);
    TaskEntity updateTask(TaskEntity task, Long id);
    void deleteTask(Long id);
    //List<TaskEntity> getAllTasks(String namecat);


}
