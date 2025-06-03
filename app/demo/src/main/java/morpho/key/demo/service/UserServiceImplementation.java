package morpho.key.demo.service;

import lombok.RequiredArgsConstructor;
import morpho.key.demo.entity.City;
import morpho.key.demo.entity.Country;
import morpho.key.demo.entity.User;
import morpho.key.demo.exceptions.UserAlreadyExist;
import morpho.key.demo.repository.CityRepository;
import morpho.key.demo.repository.CountryRepository;
import morpho.key.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registrerUser(User user) {
        if(userRepository.existsUserByName(user.getName())){
            throw new UserAlreadyExist("Username already exists");
        }
        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
        user.setUserID(UUID.randomUUID());
        City city=user.getCity();
        Country country=city.getCountry();

        if(country.getCountryID()==null && !countryRepository.existsByCountryCode(country.getCountryCode())){
            country.setCountryID(UUID.randomUUID());
            country=countryRepository.save(country);
            city.setCountry(country);
        }else{
            country=countryRepository.findCountryByCountryCode(country.getCountryCode());
            city.setCountry(country);
        }

        if(city.getCityID()==null && !cityRepository.existsByCodeCity(city.getCodeCity())){
            city.setCityID(UUID.randomUUID());
            city=cityRepository.save(city);
        }else{
            city=cityRepository.findCityByCodeCity(city.getCodeCity());
        }

        user.setCity(city);
        return userRepository.save(user);
    }

    @Override
    public User loginUser(User user) {
        User userFound=findByEmailAndPassword(user.getEmail(), user.getPasswordHash());
        if(userFound==null){
            throw new UserAlreadyExist("Username no already exists");
        }
        passwordEncoder.matches(user.getPasswordHash(), userFound.getPasswordHash());
        return null;
    }

    @Override
    public Optional<User> findByUsername(String name) {
        return name.isBlank() && !(name.length()<55)? null:userRepository.findByName(name);
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return null;
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        return null;
    }

    @Override
    public Optional<List<User>> findAllUsersByName(String name) {
        return Optional.empty();
    }

    @Override
    public Optional<List<User>> findAllUsersByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public Optional<List<User>> findAllUsersByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public Boolean passwordMatches(User user, String password) {
        findAllUsersByEmail(user.getEmail());
        return null;
    }
}
