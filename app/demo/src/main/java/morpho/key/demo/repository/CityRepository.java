package morpho.key.demo.repository;

import morpho.key.demo.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City,Integer> {
    boolean existsCityByCodeCity(String codeCity);
    //City saveCityIfNotExists(City city);
    boolean existsByCodeCity(String codeCity);
    City findCityByCodeCity(String codeCity);
}
