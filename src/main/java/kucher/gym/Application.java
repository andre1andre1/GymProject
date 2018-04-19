package kucher.gym;

import kucher.gym.Entity.Class;
import kucher.gym.Entity.Client;
import kucher.gym.Entity.Trainer;
import kucher.gym.Service.ClassService;
import kucher.gym.Service.ClientService;
import kucher.gym.Service.TrainerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(final ClassService classService, final ClientService clientService, final TrainerService trainerService) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                Client client;
                Trainer Max = new Trainer("Max", "Merkulov", 30, null, 350, 40, "Armwrestling, bodibuilding. ");
                Trainer Loma = new Trainer("Vasiliy", "Lomachenko", 25, null, 800, 80, "Boxing, olimpic chempion. ");
                Trainer Newguy = new Trainer("Andrii", "Romenskiy", 21, null, 250, 30, "New guy ");
                Class clazz = new Class("Boxing", 500, "Group boxing", 22, 2);

//                classService.addClass(clazz);
//                trainerService.addTrainer(Max);
//                trainerService.addTrainer(Loma);
//                trainerService.addTrainer(Newguy);
//                classService.addTrainer(Loma, clazz);
//
//
//
//                for (int i = 0; i < 13; i++) {
//                    client = new Client("Andrii" + i, "Kucher" + i, 17 + i, null, 11010 + i,true, true);
//                    clientService.addClient(client);
//                    clientService.buyAbonement(client,client.isStudent());
//                    clientService.buyClasses(client,clazz);
//                    clientService.buyTrainer(client,Max,false);
//                }
//
//                for (int i = 0; i < 13; i++) {
//                    client = new Client("User" + i, "Surname" + i, 22 + i, null, 1010 + i, false, false);
//                    clientService.addClient(client);
//                    clientService.buyAbonement(client, client.isStudent());
//                    clientService.buyTrainer(client,Newguy, false);
//                }

            }
        };
    }
}