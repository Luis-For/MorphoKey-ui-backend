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
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Password")
@Entity
@Data
public class PasswordDto {
    @Id
    private UUID passwordID;
    private UUID userID;
    private String passwordHash;
    private LocalDate lastUpdate;
    @OneToOne
    private UserDto userDto;
}
