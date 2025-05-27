package morpho.key.demo.model;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="password")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PasswordModel{
    private UUID passwordID;
    private UUID userID;
    private String passwordHash;
    private LocalDate lastUpdate;
}
