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
    private Integer id;

    private String stress;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "antistress_id", referencedColumnName = "id")
    private Antistress antistress;
}
