package kucher.gym.Service;

import kucher.gym.DAO.ClassDAO;
import kucher.gym.Entity.Class;
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
public class ClassService implements ClassDAO {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClassRepository classRepository;
    @Autowired
    private TrainerRepository trainerRepository;

    @Transactional
    @Override
    public void addClass(Class clazz) {
            classRepository.save(clazz);
    }

    @Override
    public void addTrainer(Trainer trainer, Class clazz) {
        Class clazz1 = classRepository.findOne(clazz.getId());
        Trainer trainer1 = trainerRepository.findOne(trainer.getId());
        clazz1.setTrainer(trainer1);
        classRepository.saveAndFlush(clazz1);
    }

    @Override
    public void addClient(Client client, Class clazz) {
        Class clazz1 = classRepository.findOne(clazz.getId());
        Client client1 = clientRepository.findOne(client.getId());
        clazz1.addClient(client1);
        classRepository.saveAndFlush(clazz1);
    }

    @Override
    public long count() {
        return classRepository.count();
    }

    @Transactional
    @Override
    public void deleteClass(Class clazz) {
        classRepository.delete(clazz);
    }

    @Transactional
    @Override
    public void deleteClass(long id) {
        classRepository.delete(id);
    }

    @Transactional
    @Override
    public void deleteClient(Client client, Class clazz) {
        Client client1 = clientRepository.findOne(client.getId());
        Class clazz1 = classRepository.findOne(clazz.getId());
        List<Client> clients = clientRepository.findByClass(clazz);
        for (Client cl: clients) {
            if (client1.getId() == cl.getId()) {
                clazz1.clearClient(client1);
                client1.setClazz(null);
                clientRepository.saveAndFlush(client1);
                classRepository.saveAndFlush(clazz1);
            }
        }
    }

    @Transactional
    @Override
    public void deleteClient(long id, Class clazz) {
        Client client1 = clientRepository.findOne(id);
        Class clazz1 = classRepository.findOne(clazz.getId());
        List<Client> clients = clientRepository.findByClass(clazz);
        for (Client cl: clients) {
            if (client1.getId() == cl.getId()) {
                clazz1.clearClient(client1);
                client1.setClazz(null);
                clientRepository.saveAndFlush(client1);
                classRepository.saveAndFlush(clazz1);
            }
        }
    }

    @Transactional
    @Override
    public void deleteTrainer(Trainer trainer, Class clazz) {
        Trainer trainer1 = trainerRepository.findOne(trainer.getId());
        Class clazz1 = classRepository.findOne(clazz.getId());
        List<Trainer> trainers = trainerRepository.findByClass(clazz);
        for (Trainer tr: trainers) {
            if (trainer1.getId() == tr.getId()) {
                clazz1.setTrainer(null);
                trainer1.setClazz(null);
                trainerRepository.saveAndFlush(trainer1);
                classRepository.saveAndFlush(clazz1);
            }
        }
    }

    @Transactional
    @Override
    public void deleteTrainer(long id, Class clazz) {
        Trainer trainer1 = trainerRepository.findOne(id);
        Class clazz1 = classRepository.findOne(clazz.getId());
        List<Trainer> trainers = trainerRepository.findByClass(clazz);
        for (Trainer tr: trainers) {
            if (trainer1.getId() == tr.getId()) {
                clazz1.setTrainer(null);
                trainer1.setClazz(null);
                trainerRepository.saveAndFlush(trainer1);
                classRepository.saveAndFlush(clazz1);
            }
        }
    }

    @Transactional(readOnly=true)
    @Override
    public List<Client> findAllClients(Class clazz) {
        return clientRepository.findByClass(clazz);
    }

    @Transactional(readOnly=true)
    @Override
    public Class findClass(long id) {
        return classRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    @Override
    public List<Trainer> findTrainer(Trainer trainer) {
        return classRepository.findTrainer(trainer);
    }

    @Transactional(readOnly=true)
    @Override
    public List<Class> findByTitle(String title) {
        return classRepository.findByTitle(title);
    }
}
