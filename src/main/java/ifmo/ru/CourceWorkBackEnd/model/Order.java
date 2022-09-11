package ifmo.ru.CourceWorkBackEnd.model;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "order_")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Clients clients;

    private LocalDate date_;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "factory_id", referencedColumnName = "id")
    private Factory factory;

    private int priority;
    public Order() {
    }

    public Order(Clients clients, LocalDate date_, Factory factory, int priority) {
        this.clients = clients;
        this.date_ = date_;
        this.factory = factory;
        this.priority = priority;
    }


}
