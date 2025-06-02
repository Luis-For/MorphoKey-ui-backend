package morpho.key.demo.dto;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "User")
@Data
public class UserDto {
    @Id
    private UUID userID;
    private String name;
    private String last_name;
    private String email;
    private LocalDate creation_account_date;
    private LocalDate date_of_birth;
    private String role;
    private Boolean status;
    private LocalDate updated_account_date;
    private LocalDate last_login_date;
    private String passwordHash;
}
