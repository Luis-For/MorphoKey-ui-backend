package morpho.key.demo.infrastructure.persistence.repository;

import morpho.key.demo.infrastructure.persistence.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * Repositorio de acceso a datos para la entidad {@link CountryEntity}.
 * <p>
 * Esta interfaz extiende {@link JpaRepository}, lo que proporciona
 * automáticamente métodos CRUD y operaciones de paginación y ordenación
 * para {@code CountryEntity} sin necesidad de implementar lógica manual.
 * <p>
 * Forma parte de la capa de infraestructura, conectando la aplicación con
 * la base de datos y gestionando las transacciones de persistencia a través
 * de Spring Data JPA.
 *
 * <ul>
 *   <li>Permite realizar operaciones CRUD de manera automática.</li>
 *   <li>Se integra con Spring para la gestión de transacciones.</li>
 *   <li>Puede definirse consultas personalizadas usando métodos de nombre derivado
 *       o anotaciones {@code @Query}.</li>
 * </ul>
 *
 * Ejemplo de uso:
 * <pre>{@code
 * Optional<CountryEntity> country = springDataCountryRepository.findById(id);
 * }</pre>
 *
 * @see JpaRepository
 * @see CountryEntity
 */
public interface SpringDataCountryRepository extends JpaRepository<CountryEntity, Integer> {
    Optional<CountryEntity> findCountryByUserID(UUID userID);
}
