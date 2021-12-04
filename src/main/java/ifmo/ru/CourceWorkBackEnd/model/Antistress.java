package ifmo.ru.CourceWorkBackEnd.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "antistress")
public class Antistress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String kind;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "antistress_to_stress",
            joinColumns = @JoinColumn(name = "antistress_id"),
            inverseJoinColumns = @JoinColumn(name = "stress_id")
    )
    private Set<Stress> stresses;
}
