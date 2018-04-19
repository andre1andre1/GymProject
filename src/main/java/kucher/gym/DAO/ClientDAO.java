package kucher.gym.DAO;

import kucher.gym.Entity.Class;
import kucher.gym.Entity.Client;
import kucher.gym.Entity.Trainer;

import java.util.List;

public interface ClientDAO {

    void addClient(Client client);
    void buyAbonement(Client client,boolean student);
    void buyDay(Client client,boolean student);
    void buyClasses(Client client,Class clazz);
    void buyTrainer(Client client, Trainer trainer, boolean day);
    long countClients();
    void deleteClient(Client client);
    void deleteClientById(long id);
    void clearTrainerById(long id);
    void clearTrainer(Trainer trainer);
    void clearClassById(long id);
    void clearClass(Class clazz);
    List<Client> findAll();
    List<Client> findByClass(Class clazz);
    List<Client> findByTrainer(Trainer trainer);
    Client findClientById(long id);
    Client findClientBySurname(String surname);
    double rechargeBalance(Client client, double money);

}
