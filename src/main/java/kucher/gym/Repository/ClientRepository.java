package kucher.gym.Repository;

import kucher.gym.Entity.Class;
import kucher.gym.Entity.Client;
import kucher.gym.Entity.Trainer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("SELECT c FROM Client c WHERE c.trainer = :trainer")
    List<Client> findByTrainer(@Param("trainer") Trainer trainer, Pageable pageable);

    @Query("SELECT COUNT(c) FROM Client c WHERE c.trainer = :trainer")
    long countByTrainer(@Param("trainer") Trainer clazz);

    @Query("SELECT c FROM Client c WHERE c.clazz = :clazz")
    List<Client> findByClass(@Param("clazz")Class clazz);

    @Query("SELECT COUNT(c) FROM Client c WHERE c.clazz = :clazz")
    long countByClass(@Param("clazz") Class clazz);

    @Query("SELECT COUNT(c) FROM Client")
    long count();

}
