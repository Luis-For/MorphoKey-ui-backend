package morpho.key.demo.infrastructure.persistence.repository;

import morpho.key.demo.infrastructure.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataUserRepository extends JpaRepository<UserEntity,UUID> {

    boolean deleteByUserID(UUID userID);
}
