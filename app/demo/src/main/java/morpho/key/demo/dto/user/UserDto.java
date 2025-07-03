package morpho.key.demo.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;
import morpho.key.demo.entity.City;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@Data
public class UserDto {
    private UUID userID;
    private String name;
    private String last_name;
    private String email;
    private String passwordHash;
    private LocalDate creation_account_date;
    private LocalDate date_of_birth;
    private String role;
    private Boolean status;
    private String phone;
    private String profile_photo_url;
    private LocalDate updated_account_date;
    private LocalDateTime last_login_date;
    private City city;

    
}
