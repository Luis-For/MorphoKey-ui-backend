package morpho.key.demo.dto.user;

import lombok.*;
import morpho.key.demo.entity.City;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
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
    private String profilePhotoUrl;
    private CityDto city;
}
