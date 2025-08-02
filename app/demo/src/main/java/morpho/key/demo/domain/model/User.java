package morpho.key.demo.domain.model;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Modelo de User (Usuario).
 * <br/>
 * Representa un usuario registrado en el sistema, asociado a una ciudad
 * y, de forma indirecta, a un país a través de la relación City → Country.
 *<br/>
 * Relaciones:
 * - Un User pertenece a una City.
 *<br/>
 * Campos recomendados:
 * - id: Identificador único del usuario
 * - username: Nombre de usuario único
 * - email: Correo electrónico del usuario
 * - city: Ciudad en la que reside el usuario
 * <br/>
 * Auth: Luis Fornaris
 * Date: 01-08-2025
 */
@Getter
@AllArgsConstructor
public class User {
    /**
     * Los atributos con la anotación @Nullable pueden ser nulos
     */
    //identificador universal para usuario
    private final UUID userID;
    private String name;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    private final LocalDate creationAccountDate;
    private LocalDate dateOfBirth;
    private String role;
    private Boolean status;
    private final Boolean verifiedStatus;
    private LocalDate updatedAccountDate;
    private LocalDateTime lastLoginDate;
    @Nullable
    private String profilePhotoUrl;
    private City city;
}
