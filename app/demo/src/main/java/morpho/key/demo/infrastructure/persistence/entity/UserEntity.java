package morpho.key.demo.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import morpho.key.demo.domain.model.User;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Entidad JPA que representa a un usuario en la base de datos PostgresSQL.
 *
 * <p>
 * Esta clase está ubicada en la capa de infraestructura y es utilizada por
 * Hibernate/JPA para el mapeo objeto-relacional (ORM).
 * </p>
 *
 * <h3>Detalles:</h3>
 * <ul>
 *   <li>Se corresponde con la tabla <b>users</b> en PostgresSQL.</li>
 *   <li>Incluye relaciones con la entidad {@link CityEntity} mediante @ManyToOne.</li>
 *   <li>Debe permanecer libre de lógica de negocio; su propósito es únicamente persistencia.</li>
 * </ul>
 *
 * <h3>Notas de arquitectura:</h3>
 * <ul>
 *   <li>Esta clase no debe ser expuesta directamente a controladores.</li>
 *   <li>La conversión a modelos de dominio o DTOs se realiza mediante un mapper.</li>
 * </ul>
 */
@Entity
@Table(name = "user")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "userid", nullable = false)
    private UUID userID;
    @Column(name = "name",  nullable = false, length = 80)
    private String name;
    @Column(name = "last_name",  nullable = false, length = 80)
    private String lastName;
    @Column(name = "user_name", nullable = false, unique = true, length = 80)
    private String userName;
    @Column(name = "email", nullable = false, unique = true, length = 80)
    private String email;
    @Column(name = "password_hash",  nullable = false)
    private String password;
    @Column(name = "creation_account_date",  nullable = false)
    private LocalDate creationAccountDate;
    @Column(name = "date_of_birth",  nullable = false)
    private LocalDate dateOfBirth;
    @Column(name = "role",  nullable = false)
    private String role;
    @Column(name = "status",  nullable = false)
    private Boolean status;
    @Column(name = "verified",  nullable = false)
    private Boolean verifiedStatus;
    @Column(name = "updated_account_date",  nullable = false)
    private LocalDate updatedAccountDate;
    @Column(name = "last_login_date",  nullable = false)
    private LocalDateTime lastLoginDate;
    @Column(name = "profile_photo_url")
    private String profilePhotoUrl;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cityid")
    private CityEntity cityEntity;
}
