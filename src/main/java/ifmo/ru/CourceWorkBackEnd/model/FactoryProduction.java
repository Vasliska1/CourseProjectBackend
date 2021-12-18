package ifmo.ru.CourceWorkBackEnd.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "factory_production")
public class FactoryProduction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "factory_id", referencedColumnName = "id")
    private Factory factory;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "antistress_id", referencedColumnName = "id")
    private Antistress antistress;

    private int count_;
}
