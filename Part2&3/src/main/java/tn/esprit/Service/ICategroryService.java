package tn.esprit.Service;

import tn.esprit.Entity.CategoryEntity;

import java.util.List;
import java.util.Set;

public interface ICategroryService {
    CategoryEntity getCategory(Long id);
    CategoryEntity addCategory(CategoryEntity category);
    List<CategoryEntity> getCategories();
    CategoryEntity findByName(String name);

}
