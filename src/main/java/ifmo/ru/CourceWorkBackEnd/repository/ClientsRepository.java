package ifmo.ru.CourceWorkBackEnd.repository;

import ifmo.ru.CourceWorkBackEnd.model.Clients;
import ifmo.ru.CourceWorkBackEnd.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsRepository extends JpaRepository<Clients, Integer> {

}
