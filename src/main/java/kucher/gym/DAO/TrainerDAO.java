package kucher.gym.DAO;

import kucher.gym.Entity.Client;
import kucher.gym.Entity.Trainer;
import kucher.gym.Entity.Class;

import java.util.List;

public interface TrainerDAO {

    void addTrainer(Trainer trainer);
    long count();
    void clearClient(Client client, Trainer trainer);
    void clearClient(long id, Trainer trainer);
    void deleteTrainer(Trainer trainer);
    void deleteTrainer(long id);
    double monthSallary(Trainer trainer);
    List<Client> findAllClients(Trainer trainer);
    List<Trainer> findAllTrainers();
    Trainer	findTrainerById(long id);
    List<Trainer> findTrainerBySurname(String surname);

}
