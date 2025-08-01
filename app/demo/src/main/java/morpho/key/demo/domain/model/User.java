package morpho.key.demo.domain.model;

import jakarta.annotation.Nullable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Modelo de User (Usuario).
 *
 * Representa un usuario registrado en el sistema, asociado a una ciudad
 * y, de forma indirecta, a un país a través de la relación City → Country.
 *
 * Relaciones:
 * - Un User pertenece a una City.
 *
 * Campos recomendados:
 * - id: Identificador único del usuario
 * - username: Nombre de usuario único
 * - email: Correo electrónico del usuario
 * - city: Ciudad en la que reside el usuario
 * Auth: Luis Fornaris
 * Date: 01-08-2025
 */
public class User {
    /**
     * los atributos con la anotacion @Nullable pueden ser nulos
     */
    //identificador universal para usuario
    private UUID userID;
    private String name;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    private LocalDate creationAccountDate;
    private LocalDate dateOfBirth;
    private String role;
    private Boolean status;
    private Boolean verifiedStatus;
    private LocalDate updatedAccountDate;
    private LocalDateTime lastLoginDate;
    @Nullable
    private String profilePhotoUrl;
    private City city;
}
