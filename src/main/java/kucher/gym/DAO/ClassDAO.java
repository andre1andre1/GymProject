package kucher.gym.DAO;

import kucher.gym.Entity.Client;
import kucher.gym.Entity.Trainer;
import kucher.gym.Entity.Class;
import java.util.List;

public interface ClassDAO {

    void addClass(Class clazz);
    void addTrainer(Trainer trainer, Class clazz);
    void addClient(Client client, Class clazz);
    long count();
    void deleteClass(Class clazz);
    void deleteClass(long id);
    void deleteClient(Client client, Class clazz);
    void deleteClient(long id, Class clazz);
    void deleteTrainer(Trainer trainer, Class clazz);
    void deleteTrainer(long id, Class clazz);
    List<Client> findAllClients(Class clazz);
    Class findClass(long id);
    List<Trainer> findTrainer(Trainer trainer);
    List<Class>	findByTitle(String surname);

}
