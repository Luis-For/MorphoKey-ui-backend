package morpho.key.demo.model;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="user")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserModel {
    @Id
    @GeneratedValue
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
}
