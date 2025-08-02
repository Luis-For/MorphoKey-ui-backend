package morpho.key.demo.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Model
 */

@Getter
@AllArgsConstructor
public class CityDto {
    private Integer id;
    private String name;
    private CountryDto country;
}
