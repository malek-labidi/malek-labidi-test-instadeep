package tn.esprit.Controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Entity.CategoryEntity;
import tn.esprit.Entity.TaskEntity;
import tn.esprit.Service.ICategroryService;
import tn.esprit.Service.ITaskService;

import java.util.List;

@RestController

// Lombok annotation to automatically generate a logger field
@Slf4j

// Lombok annotation to generate an all-args constructor
@AllArgsConstructor

// Spring annotation for specifying the base URL path for all endpoints in the controller
@RequestMapping("Task")
public class TaskController {
    // Injecting the IExamenService dependency using constructor injection
    @Autowired
    ITaskService taskService;

//    @GetMapping("all/{cat}")
//    public List<TaskEntity> getAll(String cat) {
//        // Delegating the test method call to the injected service
//        return taskService.getAllTasks(cat);
//    }
    @PostMapping("/add")
    public TaskEntity addTask(TaskEntity task) {
        // Delegating the test method call to the injected service
        return taskService.addTask(task);
    }
    @PutMapping("/put/{id}")
    public TaskEntity putTask(TaskEntity task, Long id) {
        // Delegating the test method call to the injected service
        return taskService.updateTask(task, id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    @PutMapping("/assign/{id}")
    public TaskEntity assignCatToTask(String cat, Long id) {
        // Delegating the test method call to the injected service
        return taskService.assignCategoryToTask(id, cat);
    }
    @PutMapping("/remove/{id}")
    public TaskEntity removeCatToTask(String cat, Long id) {
        // Delegating the test method call to the injected service
        return taskService.removeCategoryFromTask(id,cat);
    }
}
