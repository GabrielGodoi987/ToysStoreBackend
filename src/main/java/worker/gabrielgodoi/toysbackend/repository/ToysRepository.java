package worker.gabrielgodoi.toysbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import worker.gabrielgodoi.toysbackend.entities.Toys;

@Repository
public interface ToysRepository extends JpaRepository<Toys, Long> {
}
