package ifmo.ru.CourceWorkBackEnd.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product_list")
public class ProductList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "antistress_id", referencedColumnName = "id")
    private Antistress antistress;

    private int count_;
}
