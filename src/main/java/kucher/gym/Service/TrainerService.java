package kucher.gym.Service;

import kucher.gym.DAO.TrainerDAO;
import kucher.gym.Entity.Client;
import kucher.gym.Entity.Trainer;
import kucher.gym.Repository.ClassRepository;
import kucher.gym.Repository.ClientRepository;
import kucher.gym.Repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class TrainerService implements TrainerDAO {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClassRepository classRepository;
    @Autowired
    private TrainerRepository trainerRepository;

    @Transactional
    @Override
    public void addTrainer(Trainer trainer) {
        trainerRepository.save(trainer);
    }

    @Transactional(readOnly=true)
    @Override
    public long count() {
        return trainerRepository.count();
    }

    @Transactional
    @Override
    public void clearClient(Client client, Trainer trainer) {
        Trainer trainer1 = trainerRepository.findOne(trainer.getId());
        Client client1 = clientRepository.findOne(client.getId());
        List<Client> clients = trainer1.getClients();
        for (Client cl: clients) {
            if (client1.getId() == cl.getId()) {
                trainer1.clearClient(cl);
                client1.setTrainer(null);
                clientRepository.saveAndFlush(client1);
                trainerRepository.saveAndFlush(trainer1);
            }
        }
    }

    @Transactional
    @Override
    public void clearClient(long id, Trainer trainer) {
        Trainer trainer1 = trainerRepository.findOne(trainer.getId());
        Client client1 = clientRepository.findOne(id);
        List<Client> clients = trainer1.getClients();
        for (Client cl: clients) {
            if (client1.getId() == cl.getId()) {
                trainer1.clearClient(client1);
                client1.setTrainer(null);
                clientRepository.saveAndFlush(client1);
                trainerRepository.saveAndFlush(trainer1);
            }
        }
    }

    @Transactional
    @Override
    public void deleteTrainer(Trainer trainer) {
        trainerRepository.delete(trainer);
    }

    @Transactional
    @Override
    public void deleteTrainer(long id) {
        trainerRepository.delete(id);
    }

    @Transactional(readOnly=true)
    @Override
    public double monthSallary(Trainer trainer) {
        Trainer trainer1 = trainerRepository.findOne(trainer.getId());
        return trainer1.getSallary();
    }

    @Transactional(readOnly=true)
    @Override
    public List<Client> findAllClients(Trainer trainer) {
        return clientRepository.findByTrainer(trainer,null);
    }

    @Transactional(readOnly=true)
    @Override
    public List<Trainer> findAllTrainers() {
        return trainerRepository.findAll();
    }

    @Transactional(readOnly=true)
    @Override
    public Trainer findTrainerById(long id) {
        return trainerRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    @Override
    public List<Trainer> findTrainerBySurname(String surname) {
        return trainerRepository.findBySurname(surname);
    }
}
