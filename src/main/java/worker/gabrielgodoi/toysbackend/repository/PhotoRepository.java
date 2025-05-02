package worker.gabrielgodoi.toysbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import worker.gabrielgodoi.toysbackend.entities.Photo;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
