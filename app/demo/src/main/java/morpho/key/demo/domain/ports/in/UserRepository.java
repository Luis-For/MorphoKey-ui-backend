package morpho.key.demo.domain.ports.in;

import morpho.key.demo.domain.model.User;

import java.util.Optional;

/**
 * Puerto de entrada (Inbound Port) para la gestión de usuarios.
 *
 * Este puerto define las operaciones disponibles para interactuar
 * con el agregado User desde la capa de aplicación, sin exponer
 * detalles de infraestructura.
 * <br/>
 * Caso de uso principal:
 * - Registrar un nuevo usuario en el sistema.
 *<br/>
 * Notas:<br/>
 * - La implementación de este puerto pertenece a la capa de aplicación.<br/>
 * - Los controladores (REST, gRPC, CLI) son adaptadores que invocan este puerto.<br/>
 *<br/>
 * Ejemplo de flujo:<br/>
 *  1. Un cliente HTTP envía un JSON con email, username y cityId.<br/>
 *  2. El controlador REST invoca este puerto.<br/>
 *  3. La implementación del puerto valida la data y usa puertos de salida<br/>
 *     (UserRepository, CityRepository) para persistir el usuario.
 *     <br/>
 * Auth: Luis Fornaris<br/>
 * Version: 1.0<br/>
 * Date: 01-08-2025
 */

public interface UserRepository {
    /**
     * Registra un nuevo usuario en el sistema.
     *
     * @param user userModel
     * @return El usuario registrado, incluyendo su ID generado
     * @throws IllegalArgumentException Si el email es inválido
     * @throws IllegalStateException Si el usuario ya existe
     */
    User saveUser(User user);
    ///Buscar usuario por el id y lo retorna si lo encuentra
    Optional<User> findUserById(Long id);
    ///Actualizar usuario
    User updateUser(User user);
    ///Devuelve cierto si el usuario ha sido eliminado correctamente
    boolean deleteUser(User user);
}
