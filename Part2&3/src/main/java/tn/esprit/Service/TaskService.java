package tn.esprit.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.Entity.CategoryEntity;
import tn.esprit.Entity.TaskEntity;
import tn.esprit.Repository.CategoryRepository;
import tn.esprit.Repository.TaskRepository;

import java.util.List;

// Declaring the class as a Spring service
@Service
// Generating an all-args constructor using Lombok
@AllArgsConstructor
// Adding a logger to the class
@Slf4j
// Implementing the IExamenService interface
public class TaskService implements ITaskService {

    private TaskRepository taskRepository;
    private CategoryRepository categoryRepository;

    @Override
    public TaskEntity addTask(TaskEntity task) {
        return taskRepository.save(task);
    }

    @Override
    public TaskEntity assignCategoryToTask(Long id, String category) {
        TaskEntity task = taskRepository.findById(id).get();
        CategoryEntity categoryEntity = categoryRepository.findByName(category);
        task.getCategories().add(categoryEntity);
        return taskRepository.save(task);
    }

    @Override
    public TaskEntity removeCategoryFromTask(Long id, String category) {
        TaskEntity task = taskRepository.findById(id).get();
        CategoryEntity categoryEntity = categoryRepository.findByName(category);
        task.getCategories().remove(categoryEntity);
        return taskRepository.save(task);
    }

    @Override
    public TaskEntity updateTask(TaskEntity task, Long id) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        TaskEntity task = taskRepository.findById(id).get();
        taskRepository.delete(task);
    }

//    @Override
//    public List<TaskEntity> getAllTasks(String namecat) {
//        CategoryEntity categoryEntity = categoryRepository.findByName(namecat);
//        return taskRepository.findAllByCategory(categoryEntity);
//    }
}
