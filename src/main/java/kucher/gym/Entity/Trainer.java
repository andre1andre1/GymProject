package kucher.gym.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="Trainers")
@NoArgsConstructor
@Getter
@Setter
public class Trainer {

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
    private double sallary;

    @OneToMany(mappedBy="trainer", cascade = CascadeType.ALL)
    private List<Client> clients = new ArrayList<Client>();

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="trclass_ID")
    private Class clazz1;

    private int	priceMonth;
    private int	priceDay;
    private String	description;

    public Trainer(String name, String surname, int age, byte[] photo, int priceMonth, int priceDay, String description) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.photo = photo;
        this.priceMonth = priceMonth;
        this.priceDay = priceDay;
        this.description = description;
    }

    public void addClient(Client client){
        clients.add(client);
    }

    public Client getClient(Client client){
        for (Client cl: clients) {
            if(cl.equals(client)){
                return cl;
            }
        }
        return  null;
    }

    public void clearClient(Client client){
      clients.remove(client);
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

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public Class getClazz() {
        return clazz1;
    }

    public void setClazz(Class clazz) {
        this.clazz1 = clazz;
    }

    public int getPriceMonth() {
        return priceMonth;
    }

    public void setPriceMonth(int priceMonth) {
        this.priceMonth = priceMonth;
    }

    public int getPriceDay() {
        return priceDay;
    }

    public void setPriceDay(int priceDay) {
        this.priceDay = priceDay;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getSallary() {
        return sallary;
    }

    public void setSallary(double sallary) {
        this.sallary = sallary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Trainer trainer = (Trainer) o;

        if (id != trainer.id) return false;
        if (age != trainer.age) return false;
        if (!name.equals(trainer.name)) return false;
        return surname.equals(trainer.surname);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "id= " + id +
                ", name= '" + name + '\'' +
                ", surname= '" + surname + '\'' +
                ", age= " + age +
                ", priceMonth= " + priceMonth +
                ", priceDay= " + priceDay +
                ", description= '" + description + '\'' +
                '}';
    }
}
