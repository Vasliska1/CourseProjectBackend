package ifmo.ru.CourceWorkBackEnd.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "delivery_fact")
public class DeliveryFact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "deliveryman_id", referencedColumnName = "id")
    private DeliveryMan deliveryMan;

    private Boolean delivery_fact;

    private Date delivery_date;

}
