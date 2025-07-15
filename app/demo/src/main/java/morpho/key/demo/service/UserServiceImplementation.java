package morpho.key.demo.service;

import lombok.RequiredArgsConstructor;
import morpho.key.demo.dto.user.CityDto;
import morpho.key.demo.dto.user.CountryDto;
import morpho.key.demo.dto.user.UserDto;
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

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    public User registrerUser(UserDto user) {
        // Validar si ya existe usuario con mismo email o username
        if (userRepository.existsByEmail(user.getEmail()) || userRepository.existsByUserName(user.getUserName())) {
            throw new UserAlreadyExist("Email or Username already exists");
        }

        // Crear entidad User con datos básicos
        User userEntity = User.builder()
                .name(user.getName())
                .lastName(user.getLastName())
                .userName(user.getUserName())
                .email(user.getEmail())
                .password(passwordEncoder.encode(user.getPassword()))
                .creationAccountDate(LocalDate.now())
                .updatedAccountDate(LocalDate.now())
                .lastLoginDate(LocalDateTime.now())
                .dateOfBirth(user.getDateOfBirth())
                .role(user.getRole())
                .status(true)
                .verifiedStatus(false)
                .build();

        // Buscar o crear país
        Optional<Country> countryOptional=countryRepository.findByCountryCode(user.getCity().getCountry().getCountryCode());
        Country country;
        if(countryOptional.isPresent()){
            country=countryOptional.get();
        }else{
            country=Country.builder()
                    .countryName(user.getCity().getCountry().getName())
                    .countryCode(user.getCity().getCountry().getCountryCode())
                    .build();
            countryRepository.save(country);
        }

        // Buscar o crear ciudad
        Optional<City> cityOptional = cityRepository.findCityByNameCity(user.getCity().getName());
        City city;
        if (cityOptional.isPresent()) {
            city=cityOptional.get();
        }else{
            city = City.builder()
                    .nameCity(user.getCity().getName())
                    .country(country)
                    .build();
            city = cityRepository.save(city);
        }

        // Asignar ciudad persistida al usuario
        userEntity.setCity(city);
        return userRepository.save(userEntity);
    }


    @Override
    public User loginUser(UserDto user) {
        /*User userFound=findByEmailAndPassword(user.getEmail(), user.getPasswordHash()).get();
        if(userFound==null){
            throw new UserAlreadyExist("Username no already exists");
        }
        passwordEncoder.matches(user.getPasswordHash(), userFound.getPasswordHash());*/
        return null;
    }

    @Override
    public Optional<User> findByUsername(String name) {
        return name.isBlank() && !(name.length()<55)? null:userRepository.findByName(name);
    }

    @Override
    public Optional<User> findByEmailAndPassword(String email, String password) {
        if(userRepository.existsUserByEmail(email)){

        }
        return null;
    }
}
