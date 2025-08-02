package morpho.key.demo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
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
@Getter
@AllArgsConstructor
public class City {
    /***
     * Idendificador de cada ciudad autoincremental
     */
    private final Integer cityId;
    private final String name;
    /**
     * model pais
     */
    private final Country country;
}
