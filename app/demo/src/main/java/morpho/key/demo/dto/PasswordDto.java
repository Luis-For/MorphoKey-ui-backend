package morpho.key.demo.dto;

import java.time.LocalDate;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PasswordDto {
    private UUID passwordID;
    private UUID userID;
    private String passwordHash;
    private LocalDate lastUpdate;
}
