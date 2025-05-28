package worker.Inklings.toysbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import worker.Inklings.toysbackend.entities.Toys;

import java.util.List;

@Repository
public interface ToysRepository extends JpaRepository<Toys, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM tb_toys WHERE category_id = :categoryId")
    List<Toys> findByCategoryId(Long categoryId);
}
