package morpho.key.demo.repository;

import java.awt.print.Pageable;
import java.util.Optional;
import java.util.UUID;

import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import morpho.key.demo.entity.User;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, UUID>{
    Optional<User> findByName(String name);
    boolean existsUserByName(String name);
}
