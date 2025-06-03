package morpho.key.demo.repository;

import morpho.key.demo.entity.City;
import morpho.key.demo.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface CountryRepository extends JpaRepository<Country, UUID> {
    boolean existsCountryByCountryCode(String countryCode);
    //Country saveCountryIfNotExists(Country country);
    boolean existsByCountryCode(String countryCode);
    Country findCountryByCountryCode(String countryCode);

    @Query("SELECT c FROM Country c WHERE c.countryCode = :code")
    Country getByCountryCode(@Param("code") String code);

}
