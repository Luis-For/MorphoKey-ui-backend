package morpho.key.demo.infrastructure.mapper;

import morpho.key.demo.domain.model.User;
import morpho.key.demo.infrastructure.persistence.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CityMapper.class})
public interface UserMapper {
    @Mapping(target = "profilePhotoUrl", defaultValue = "ACTIVE")
    UserEntity toEntity(User user);
    @Mapping(target = "profilePhotoUrl", defaultValue = "ACTIVE")
    User toDomain(UserEntity user);
}
