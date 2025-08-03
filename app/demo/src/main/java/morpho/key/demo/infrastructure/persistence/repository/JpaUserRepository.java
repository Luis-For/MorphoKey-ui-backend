package morpho.key.demo.infrastructure.persistence.repository;

import lombok.AllArgsConstructor;
import morpho.key.demo.domain.model.User;
import morpho.key.demo.domain.ports.in.UserRepository;
import morpho.key.demo.infrastructure.mapper.UserMapper;
import morpho.key.demo.infrastructure.persistence.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 *
 */

@Repository
@AllArgsConstructor
public class JpaUserRepository implements UserRepository {
    @Autowired
    private final SpringDataUserRepository springDataUserRepository;
    @Autowired
    private final UserMapper userMapper;

    /**
     * Persiste un usuario en la base de datos.
     * <p>
     * Este metodo recibe un objeto de dominio {@code User}, lo convierte a
     * {@code UserEntity} mediante {@code UserMapper}, lo guarda en la base de datos
     * utilizando JPA ({@code save}) y finalmente retorna el objeto guardado
     * convertido nuevamente al modelo de dominio.
     *
     * @param user Objeto de dominio que representa al usuario a guardar
     * @return Usuario guardado en el modelo de dominio
     */

    @Override
    public User saveUser(User user) {
        return userMapper.toDomain(springDataUserRepository.save(userMapper.toEntity(user)));
    }

    /**
     *
     * @param id Id del Objeto de dominio que representa al usuario a buscar
     * @return
     */
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
