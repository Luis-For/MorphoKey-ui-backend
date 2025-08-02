package morpho.key.demo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Modelo de Country (País).
 *
 * Representa un país dentro del sistema. Este modelo sirve como entidad
 * para almacenar la información principal de un país y facilitar su
 * transporte entre capas de la aplicación (DTO/Entity).
 *
 * Relaciones:
 * - Un Country puede tener múltiples City.
 *
 * Campos recomendados:
 * - id: Identificador único del país
 * - name: Nombre oficial del país
 * - isoCode: Código ISO del país (opcional pero útil para integraciones)
 * Auth: Luis Fornaris
 * Date:08-01-2025
 */
@Getter
@AllArgsConstructor
public class Country {
    /**
     * El identificador no sera puesto de forma automatica, se utilizara para separarlo del codigo del pais ISO 3166-1 alpha-2
     */
    private final Integer countryId;
    private final String name;
}
