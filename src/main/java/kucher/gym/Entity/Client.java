package kucher.gym.Entity;


import lombok.NoArgsConstructor;
import lombok.NonNull;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name="Clients")
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String	name;
    @Column(nullable = false)
    private String	surname;
    @Column(nullable = false)
    private int	age;
    private byte[]	photo;
    private double	balance;

    @ManyToOne
    @JoinColumn(name="trainer_id")
    private Trainer	trainer;

    @ManyToOne
    @JoinColumn(name="clclass_id")
    private Class clazz;

    private boolean	student;
    private boolean	fullday;


    public Client(String name, String surname, int age, byte[] photo, double balance, boolean student, boolean fullday) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.photo = photo;
        this.balance = balance;
        this.student = student;
        this.fullday = fullday;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public boolean isStudent() {
        return student;
    }

    public void setStudent(boolean student) {
        this.student = student;
    }

    public boolean isFullday() {
        return fullday;
    }

    public void setFullday(boolean fullday) {
        this.fullday = fullday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (id != client.id) return false;
        if (age != client.age) return false;
        if (!name.equals(client.name)) return false;
        return surname.equals(client.surname);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + surname.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id= " + id +
                ", name= '" + name + '\'' +
                ", surname= '" + surname + '\'' +
                ", age= " + age +
                ", balance= " + balance +
                ", trainer= " + trainer.getName() +
                ", clazz= " + clazz.getTitle() +
                ", student= " + student +
                ", fullday= " + fullday +
                '}';
    }
}
