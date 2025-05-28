package worker.Inklings.toysbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import worker.Inklings.toysbackend.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
