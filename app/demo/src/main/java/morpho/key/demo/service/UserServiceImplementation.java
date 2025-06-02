package morpho.key.demo.service;

import lombok.RequiredArgsConstructor;
import morpho.key.demo.dto.UserDto;
import morpho.key.demo.exceptions.UserAlreadyExist;
import morpho.key.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto registrerUser(UserDto userDto, String password) {
        if(userRepository.existsByUsername(userDto.getName())){
            throw new UserAlreadyExist("Username already exists");
        }
        userDto.setPasswordHash(passwordEncoder.encode(userDto.getPasswordHash()));
        return userRepository.save(userDto);
    }

    @Override
    public UserDto loginUser(UserDto userDto) {
        return null;
    }

    @Override
    public Optional<UserDto> findByUsername(String username, Pageable pageable) {
        return username.isBlank() && !(username.length()<55)? null:userRepository.findByUsername(username, pageable);
    }

    @Override
    public UserDto findByEmail(String email) {
        return null;
    }

    @Override
    public UserDto findByUsernameAndPassword(String username, String password) {
        return null;
    }

    @Override
    public UserDto findByEmailAndPassword(String email, String password) {
        return null;
    }

    @Override
    public Optional<List<UserDto>> findAllUsersByName(String name) {
        return Optional.empty();
    }

    @Override
    public Optional<List<UserDto>> findAllUsersByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public Optional<List<UserDto>> findAllUsersByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public Boolean passwordMatches(UserDto userDto, String password) {
        findAllUsersByEmail(userDto.getEmail());
        return null;
    }
}
