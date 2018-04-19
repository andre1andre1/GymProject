package kucher.gym.Repository;

import kucher.gym.Entity.Class;
import kucher.gym.Entity.Client;
import kucher.gym.Entity.Trainer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClassRepository extends JpaRepository<Class, Long> {

    @Query("SELECT COUNT(c) FROM Class")
    long count();

    @Query("SELECT c  FROM Class c WHERE c.clients = :client")
    List<Client> findClient(@Param("client") Client client);

    @Query("SELECT c FROM Class c WHERE c.trainer1 = :trainer")
    List<Trainer> findTrainer(@Param("trainer") Trainer trainer);

    @Query("SELECT c FROM Class c WHERE LOWER(c.title) LIKE LOWER(CONCAT('%', :title, '%'))")
    List<Class> findByTitle(@Param("title") String title);
}
