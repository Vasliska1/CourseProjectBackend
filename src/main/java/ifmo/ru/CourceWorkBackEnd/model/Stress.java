package ifmo.ru.CourceWorkBackEnd.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "stress_kind")
public class Stress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String stress;

    @ManyToMany(mappedBy = "stresses")
    private List<Antistress> antistresses;
}
