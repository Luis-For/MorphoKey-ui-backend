package morpho.key.demo.domain.model;

import lombok.Data;
import morpho.key.demo.dto.user.CountryDto;
/**
 * Modelo de City (Ciudad).
 *
 * Representa una ciudad registrada dentro de un país. Permite asociar
 * usuarios a ubicaciones geográficas más específicas.
 *
 * Relaciones:
 * - Una City pertenece a un Country.
 * - Una City puede tener múltiples User.
 *
 * Campos recomendados:
 * - id: Identificador único de la ciudad
 * - name: Nombre de la ciudad
 * - country: Referencia al país al que pertenece
 */
@Data
public class City {
    /***
     * Idendificador de cada ciudad autoincremental
     */
    private Integer cityId;
    private String name;
    /**
     * model pais
     */
    private CountryDto country;
}
