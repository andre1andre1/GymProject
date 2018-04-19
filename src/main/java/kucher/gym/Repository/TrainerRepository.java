package kucher.gym.Repository;

import kucher.gym.Entity.Class;
import kucher.gym.Entity.Client;
import kucher.gym.Entity.Trainer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {

    @Query("SELECT c FROM Trainer c WHERE LOWER(c.surname) LIKE LOWER(CONCAT('%', :pattern, '%'))")
    List<Trainer> findBySurname(@Param("pattern") String pattern);

    @Query("SELECT COUNT(c) FROM Trainer")
    long count();

    @Query("SELECT c FROM Trainer c WHERE c.clazz1 = :clazz")
    List<Trainer> findByClass(@Param("clazz")Class clazz);
}
