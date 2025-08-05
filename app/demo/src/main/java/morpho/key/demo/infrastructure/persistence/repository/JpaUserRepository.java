package morpho.key.demo.infrastructure.persistence.repository;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import morpho.key.demo.domain.model.User;
import morpho.key.demo.domain.ports.out.UserRepository;
import morpho.key.demo.infrastructure.mapper.UserMapper;
import morpho.key.demo.infrastructure.persistence.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 *  Esta clase {@code JpaUserRepository} implementa {@code UserRepository} el cual es el adaptador de salida la capa de {@code dominio}
 *  y utiliza
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
    public User saveUser(User user){
        return userMapper.toDomain(springDataUserRepository.save(userMapper.toEntity(user)));
    }

    /**
     * Este metodo
     * @param id
     * @return
     */
    @Override
    public User getUser(UUID id) {
        return userMapper.toDomain(springDataUserRepository.findById(id).orElse(null));
    }

    /**
     * Este metodo recibe el ID de un {@code user}, y lo elimina de la base de datos utilizando JPA ({@code deleteByUserId})
     * y finalmente si ha sido eliminado correctamente retorna {@code true}, si no retorna {@code false}
     * @param id
     * @return true si fue eliminado y false si no
     */
    @Override
    public boolean deleteUser(UUID id) {
        return springDataUserRepository.deleteByUserID(id);
    }

    /**
     * Este metodo recibe el email del usuario como parametro y consulta el ID del usuario registrado, si este existe lo devuelve y si no retorna null
     * @param email
     * @return
     */
    @Override
    public UUID getUserIdByEmail(String email) {
        return springDataUserRepository.findByEmail(email).stream()
                .map(UserEntity::getUserID)
                .findFirst()
                .orElse(null);
    }
}
