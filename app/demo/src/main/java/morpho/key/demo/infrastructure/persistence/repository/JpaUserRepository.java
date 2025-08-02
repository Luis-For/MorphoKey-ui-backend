package morpho.key.demo.infrastructure.persistence.repository;

import lombok.AllArgsConstructor;
import morpho.key.demo.domain.model.User;
import morpho.key.demo.domain.ports.in.UserRepository;
import morpho.key.demo.infrastructure.persistence.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class JpaUserRepository implements UserRepository {
    @Autowired
    private final SpringDataUserRepository springDataUserRepository;

    @Override
    public User saveUser(User user) {
        UserEntity userEntity = UserEntity.fromDomain(user);
        return springDataUserRepository.save(user);
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return Optional.empty();
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public boolean deleteUser(User user) {
        return springDataUserRepository.deleteByUserID(user.getUserID());
    }
}
