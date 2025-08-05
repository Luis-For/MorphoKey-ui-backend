package morpho.key.demo.domain.model;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

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
    @NotNull
    @Size(min = 1, max = 50)
    private String name;
    @NotNull
    @Size(min = 1, max = 50)
    private String lastName;
    @NotNull
    @Size(min = 1, max = 50)
    private String userName;
    @NotNull
    @Email
    private String email;
    @NotNull
    private String password;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private final LocalDate creationAccountDate;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
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
