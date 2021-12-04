package ifmo.ru.CourceWorkBackEnd.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "clients")
public class Clients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "human_id", referencedColumnName = "id")
    private Human human;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subscription_id", referencedColumnName = "id")
    private Subscription subscription;

    public Clients(Human id_human, Location id_delivery_place, Subscription id_subscription, User id_user) {
        this.human = id_human;
        this.location = id_delivery_place;
        this.subscription = id_subscription;
        this.user = id_user;
    }

    public Clients() {
    }
}
