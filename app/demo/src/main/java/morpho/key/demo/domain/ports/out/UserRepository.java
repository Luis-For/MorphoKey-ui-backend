package morpho.key.demo.domain.ports.out;

import morpho.key.demo.domain.model.User;

import java.util.UUID;

public interface UserRepository {
    User saveUser(User user);
    User getUser(UUID id);
    UUID getUserIdByEmail(String email);
    boolean deleteUser(UUID id);
}
