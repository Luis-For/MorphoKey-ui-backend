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
public class UserDto {
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
