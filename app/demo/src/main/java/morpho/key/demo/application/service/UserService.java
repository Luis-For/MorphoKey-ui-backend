package morpho.key.demo.application.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import morpho.key.demo.domain.model.User;
import morpho.key.demo.domain.ports.in.UserManagementUseCase;
import morpho.key.demo.domain.ports.out.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService implements UserManagementUseCase {
    @Autowired
    private final UserRepository userRepository;
    @Override
    public User createUser(User user) {
        //validacion de datos de user y que no exista
        if (user==null || userRepository.getUserIdByEmail(user.getEmail()) != null) {
            return null;
        }

        //validando que no exista
        try{
            UUID userId=userRepository.getUserIdByEmail(user.getEmail());
        } catch (EntityNotFoundException entityNotFoundException) {
            throw new RuntimeException(entityNotFoundException.getMessage().concat("El usuario con el correo electronico ya existe"));
        }finally {

        }

        //guardando el usuario
        return userRepository.saveUser(user);
    }
}
