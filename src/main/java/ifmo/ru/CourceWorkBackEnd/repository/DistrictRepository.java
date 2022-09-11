package ifmo.ru.CourceWorkBackEnd.repository;

import ifmo.ru.CourceWorkBackEnd.model.Clients;
import ifmo.ru.CourceWorkBackEnd.model.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DistrictRepository  extends JpaRepository<District, Integer> {

    @Query(value = "select name from district where city_id = :id order by name",  nativeQuery = true)
    List<String> getNamebyCity(@Param("id") int city);

    @Query(value = "select * from district where city_id = :id and name= :name",  nativeQuery = true)
    District findByIdCityAndName(@Param("id") int id, @Param("name") String name);
}
