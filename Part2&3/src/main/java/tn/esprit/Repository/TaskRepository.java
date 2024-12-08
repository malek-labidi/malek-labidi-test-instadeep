package tn.esprit.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.Entity.CategoryEntity;
import tn.esprit.Entity.TaskEntity;

import java.util.List;
// Declaring the interface as a Spring Data repository
@Repository
public interface TaskRepository extends CrudRepository<TaskEntity, Long> {
   // List<TaskEntity> findAllByCategory(CategoryEntity category);
}
