package ifmo.ru.CourceWorkBackEnd.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "deliveryman")
public class DeliveryMan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "human_id", referencedColumnName = "id")
    private Human human;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "district_id", referencedColumnName = "id")
    private District district;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;
}
