package morpho.key.demo.service;

import morpho.key.demo.dto.UserDto;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDto registrerUser(UserDto userDto, String password);
    UserDto loginUser(UserDto userDto);
    Optional<UserDto> findByUsername(String username, Pageable pageable);
    UserDto findByEmail(String email);
    UserDto findByUsernameAndPassword(String username, String password);
    UserDto findByEmailAndPassword(String email, String password);
    Optional<List<UserDto>> findAllUsersByName(String name);
    Optional<List<UserDto>> findAllUsersByEmail(String email);
    Optional<List<UserDto>> findAllUsersByUsername(String username);
    Boolean passwordMatches(UserDto userDto, String password);
}
