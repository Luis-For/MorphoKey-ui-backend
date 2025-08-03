package morpho.key.demo.infrastructure.mapper;

import morpho.key.demo.domain.model.Country;
import morpho.key.demo.infrastructure.persistence.entity.CountryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CountryMapper.class})
public interface CountryMapper {
    CountryEntity toEntity(Country country);
    Country toDomain(CountryEntity countryEntity);
}
