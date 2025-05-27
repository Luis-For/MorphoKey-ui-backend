package morpho.key.demo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import morpho.key.demo.dto.UserDto;

@Repository
public interface UserRepository extends JpaRepository<UserDto, UUID>{
    
}
