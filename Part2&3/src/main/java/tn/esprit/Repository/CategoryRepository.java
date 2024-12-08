package tn.esprit.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.Entity.CategoryEntity;

import java.util.List;

// Declaring the interface as a Spring Data repository
@Repository
public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {
    CategoryEntity findByName(String name);
    List<CategoryEntity> findAll();
}
