package morpho.key.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"user\"")
public class User {
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
    private City city;
}
