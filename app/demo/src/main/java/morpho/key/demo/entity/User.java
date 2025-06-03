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
@Table(name = "User", schema = "taxokey")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userID", updatable = false, nullable = false)
    private UUID userID;
    @Column(name = "name",  nullable = false, length = 50)
    private String name;
    @Column(name = "last_name",  nullable = false, length = 50)
    private String last_name;
    @Column(name = "email", nullable = false, unique = true, length = 80)
    private String email;
    @Column(name = "password_hash",  nullable = false)
    private String passwordHash;
    @Column(name = "creation_account_date",  nullable = false)
    private LocalDate creation_account_date;
    @Column(name = "date_of_birth",  nullable = false)
    private LocalDate date_of_birth;
    @Column(name = "role",  nullable = false)
    private String role;
    @Column(name = "status",  nullable = false)
    private Boolean status;
    @Column(name = "phone")
    private String phone;
    @Column(name = "profile_photo_url")
    private String profile_photo_url;
    @Column(name = "updated_account_date",  nullable = false)
    private LocalDate updated_account_date;
    @Column(name = "last_login_date",  nullable = false)
    private LocalDateTime last_login_date;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cityID")
    private City city;
}
