package worker.Inklings.toysbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import worker.Inklings.toysbackend.entities.Photo;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
