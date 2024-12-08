package tn.esprit.Controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Entity.CategoryEntity;
import tn.esprit.Service.ICategroryService;
import tn.esprit.Service.IExamenService;

import java.util.List;

@RestController

// Lombok annotation to automatically generate a logger field
@Slf4j

// Lombok annotation to generate an all-args constructor
@AllArgsConstructor

// Spring annotation for specifying the base URL path for all endpoints in the controller
@RequestMapping("Category")
public class CategoryController {
    // Injecting the IExamenService dependency using constructor injection
    @Autowired
    ICategroryService categoryService;

    @GetMapping("all")
    public List<CategoryEntity> getAll() {
        // Delegating the test method call to the injected service
        return categoryService.getCategories();
    }
    @PostMapping("add")
    public CategoryEntity addCat(CategoryEntity cat) {
        // Delegating the test method call to the injected service
        return categoryService.addCategory(cat);
    }

}
