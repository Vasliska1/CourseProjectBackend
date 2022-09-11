package ifmo.ru.CourceWorkBackEnd.model;

import  lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "city")
public class    City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "stress_id", referencedColumnName = "id")
    private Stress stress;
}
