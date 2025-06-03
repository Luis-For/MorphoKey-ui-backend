package morpho.key.demo.service;

import morpho.key.demo.entity.User;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface UserService {
    User registrerUser(User user);
    User loginUser(User user);
    Optional<User> findByUsername(String name);
    User findByEmail(String email);
    User findByUsernameAndPassword(String username, String password);
    User findByEmailAndPassword(String email, String password);
    Optional<List<User>> findAllUsersByName(String name);
    Optional<List<User>> findAllUsersByEmail(String email);
    Optional<List<User>> findAllUsersByUsername(String username);
    Boolean passwordMatches(User user, String password);
}
