package ifmo.ru.CourceWorkBackEnd.repository;

import ifmo.ru.CourceWorkBackEnd.model.City;
import ifmo.ru.CourceWorkBackEnd.model.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityRepository  extends JpaRepository<City, Integer> {

    City findByName(String name);

    @Query(value = "select name from city order by name",  nativeQuery = true)
    List<String> findAllCity();
}
