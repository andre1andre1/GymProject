package kucher.gym.Service;

import kucher.gym.DAO.ClientDAO;
import kucher.gym.Entity.Class;
import kucher.gym.Entity.Client;
import kucher.gym.Entity.Trainer;

import kucher.gym.Repository.ClassRepository;
import kucher.gym.Repository.ClientRepository;
import kucher.gym.Repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService implements ClientDAO {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClassRepository classRepository;
    @Autowired
    private TrainerRepository trainerRepository;

    @Transactional
    @Override
    public void addClient(Client client) {
        clientRepository.save(client);
    }

    @Transactional
    @Override
    public void buyAbonement(Client client, boolean student) {
        Client client1 = clientRepository.findOne(client.getId());
        if(student){
            client1.setBalance(client1.getBalance()- 250);
        }else {
            client1.setBalance(client1.getBalance()- 350);
        }
            clientRepository.saveAndFlush(client1);
    }


    @Transactional
    @Override
    public void buyDay(Client client, boolean student) {
        Client client1 = clientRepository.findOne(client.getId());
        if(student){
            client1.setBalance(client1.getBalance()- 25);
        }else {
            client1.setBalance(client1.getBalance()- 35);
        }
        clientRepository.saveAndFlush(client1);
    }

    @Transactional
    @Override
    public void buyClasses(Client client, Class clazz) {
        Client client1 = clientRepository.findOne(client.getId());
        client1.setBalance(client1.getBalance()- clazz.getPrice());
        clientRepository.saveAndFlush(client1);

    }

    @Transactional
    @Override
    public void buyTrainer(Client client, Trainer trainer, boolean day) {
        Client client1 = clientRepository.findOne(client.getId());
        Trainer trainer1 = trainerRepository.findOne(trainer.getId());
        if (day){
            client1.setBalance(client1.getBalance()- trainer1.getPriceDay());
            trainer1.setSallary(trainer1.getPriceDay());
        }else {
            client1.setBalance(client1.getBalance()- trainer1.getPriceMonth());
            trainer1.setSallary(trainer1.getPriceMonth());
        }

        clientRepository.saveAndFlush(client1);
        trainerRepository.saveAndFlush(trainer1);
    }


    @Override
    public long countClients() {
        return clientRepository.count();
    }

    @Transactional
    @Override
    public void deleteClient(Client client) {
        clientRepository.delete(client);
    }

    @Transactional
    @Override
    public void deleteClientById(long id) {
        clientRepository.delete(id);
    }

    @Transactional
    @Override
    public void clearTrainerById(long id) {
        Trainer trainer = trainerRepository.findOne(id);
        List<Client> clients = trainer.getClients();
        for (Client cl: clients) {
            if (trainer.getId() == cl.getTrainer().getId()) {
                trainer.getClient(cl).setTrainer(null);
                clientRepository.saveAndFlush(cl);
            }
        }
    }

    @Transactional
    @Override
    public void clearTrainer(Trainer trainer) {
        Trainer trainer1 = trainerRepository.findOne(trainer.getId());
        List<Client> clients = trainer.getClients();
        for (Client cl: clients) {
            if (trainer.getId() == cl.getTrainer().getId()) {
                trainer.getClient(cl).setTrainer(null);
                clientRepository.saveAndFlush(cl);
            }
        }
    }

    @Transactional
    @Override
    public void clearClassById(long id) {
        Class clazz = classRepository.findOne(id);
        List<Client> clients = clazz.getClients();
        for (Client cl: clients) {
            if (clazz.getId() == cl.getClazz().getId()) {
                clazz.getClient(cl).setClazz(null);
                clientRepository.saveAndFlush(cl);
            }

        }
    }

    @Transactional
    @Override
    public void clearClass(Class clazz) {
        Class clazz1 = classRepository.findOne(clazz.getId());
        List<Client> clients = clazz.getClients();
        for (Client cl: clients) {
            if (clazz1.getId() == cl.getClazz().getId()) {
                clazz1.getClient(cl).setClazz(null);
                clientRepository.saveAndFlush(cl);
            }
        }
    }

    @Transactional(readOnly=true)
    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Transactional(readOnly=true)
    @Override
    public List<Client> findByClass(Class clazz) {

        return clientRepository.findByClass(clazz);
//        List<Client> clients = clientRepository.findAll();
//        for (Client cl: clients) {
//            if(cl.getClazz().getId() == clazz.getId()){
//                clients.add(cl);
//            }
//        }
//        return clients;
    }

    @Transactional(readOnly=true)
    @Override
    public List<Client> findByTrainer(Trainer trainer) {

        return clientRepository.findByTrainer(trainer, null);
//        List<Client> clients = clientRepository.findAll();
//        for (Client cl: clients) {
//            if (trainer.getId() == cl.getTrainer().getId()) {
//                clients.add(cl);
//            }
//        }
//        return clients;
    }

    @Transactional(readOnly=true)
    @Override
    public Client findClientById(long id) {
        clientRepository.findOne(id);
        return null;
    }

    @Transactional(readOnly=true)
    @Override
    public Client findClientBySurname(String surname) {
        List<Client> clients = clientRepository.findAll();
        return null;
    }

    @Transactional
    @Override
    public double rechargeBalance(Client client, double money) {
        Client client1 = clientRepository.findOne(client.getId());
        client1.setBalance(client1.getBalance() + money);
        clientRepository.saveAndFlush(client1);
        return client1.getBalance();
    }
}
