package morpho.key.demo.repository;

import morpho.key.demo.entity.City;
import morpho.key.demo.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CityRepository extends JpaRepository<City,Integer> {
    boolean existsByNameCity(String nameCity);
    //City findCityByNameCity(String nameCity);
    Optional<City> findCityByNameCity(String nameCity);
}
