package ifmo.ru.CourceWorkBackEnd.repository;

import ifmo.ru.CourceWorkBackEnd.model.Clients;
import ifmo.ru.CourceWorkBackEnd.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientsRepository extends JpaRepository<Clients, Integer> {
    @Query(value = "select * from clients where user_id = :id",  nativeQuery = true)
    Clients getClientbyUser(@Param("id") int id);
}
