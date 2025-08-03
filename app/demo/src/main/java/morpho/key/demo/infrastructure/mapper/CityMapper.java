package morpho.key.demo.infrastructure.mapper;

import morpho.key.demo.domain.model.City;
import morpho.key.demo.infrastructure.persistence.entity.CityEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CityMapper {
    City toDomain(City city);
    City toDomain(CityEntity cityEntity);
}
