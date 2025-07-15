package morpho.key.demo.service;

import morpho.key.demo.dto.user.UserDto;
import morpho.key.demo.entity.User;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface UserService {
    User registrerUser(UserDto userDto);
    User loginUser(UserDto userDto);
    Optional<User> findByUsername(String name);
    Optional<User> findByEmailAndPassword(String email, String password);
}
