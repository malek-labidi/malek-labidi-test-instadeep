package tn.esprit.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.Entity.CategoryEntity;
import tn.esprit.Repository.CategoryRepository;
import tn.esprit.Repository.TestRepository;

import java.util.List;
import java.util.Set;

// Declaring the class as a Spring service
@Service
// Generating an all-args constructor using Lombok
@AllArgsConstructor
// Adding a logger to the class
@Slf4j
// Implementing the IExamenService interface
public class CategoryService implements  ICategroryService {
    CategoryRepository categoryRepository;

    @Override
    public CategoryEntity getCategory(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public CategoryEntity addCategory(CategoryEntity category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<CategoryEntity> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public CategoryEntity findByName(String name) {
        return categoryRepository.findByName(name);
    }
}
