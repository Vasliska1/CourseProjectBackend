package ifmo.ru.CourceWorkBackEnd.repository;

import ifmo.ru.CourceWorkBackEnd.model.Clients;
import ifmo.ru.CourceWorkBackEnd.model.DeliveryMan;
import ifmo.ru.CourceWorkBackEnd.model.FactoryProduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DeliveryManRepository extends JpaRepository<DeliveryMan, Integer> {

    @Query(value = "select * from deliveryman where user_id = :id",  nativeQuery = true)
    DeliveryMan getDeliverybyUser(@Param("id") int id);


}
