package kucher.gym.Entity;


import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="Classes")
@NoArgsConstructor
public class Class {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String	title;
    @Column(nullable = false)
    private int	price;


    @OneToOne(fetch=FetchType.LAZY, mappedBy="clazz1")
    private Trainer trainer1;

    private String	info;

    @OneToMany(mappedBy="clazz", cascade = CascadeType.ALL)
    private List<Client> clients = new ArrayList<Client>();

    private int	limit;
    private int	duration;
    private byte[]	photo;
//    private List<Day>	days; will be enum


    public Class(String title, int price, String info, int limit, int duration) {
        this.title = title;
        this.price = price;
        this.info = info;
        this.limit = limit;
        this.duration = duration;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Trainer getTrainer() {
        return trainer1;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer1 = trainer;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Class aClass = (Class) o;

        if (id != aClass.id) return false;
        if (price != aClass.price) return false;
        if (!title.equals(aClass.title)) return false;
        return trainer1 != null ? trainer1.equals(aClass.trainer1) : aClass.trainer1 == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + title.hashCode();
        result = 31 * result + price;
        result = 31 * result + (trainer1 != null ? trainer1.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", trainer=" + trainer1.getName() +
                ", info='" + info + '\'' +
                ", limit=" + limit +
                ", duration=" + duration +
                '}';
    }
}
