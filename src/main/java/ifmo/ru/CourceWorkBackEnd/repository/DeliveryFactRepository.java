package ifmo.ru.CourceWorkBackEnd.repository;

import ifmo.ru.CourceWorkBackEnd.model.DeliveryFact;
import ifmo.ru.CourceWorkBackEnd.model.DeliveryMan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DeliveryFactRepository extends JpaRepository<DeliveryFact, Integer> {

    @Query(value = "select * from delivery_fact where deliveryman_id = :id and delivery_fact = false",  nativeQuery = true)
    List<DeliveryFact> getCurrDeliv(@Param("id") int id);

    @Query(value = "select * from delivery_fact where deliveryman_id = :id and delivery_fact = true",  nativeQuery = true)
    List<DeliveryFact> getDoneDeliv(@Param("id") int id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update delivery_fact set delivery_fact = true where id = :id",  nativeQuery = true)
    void changeFact(@Param("id") int id);
}
