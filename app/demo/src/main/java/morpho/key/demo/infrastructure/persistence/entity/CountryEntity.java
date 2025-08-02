package morpho.key.demo.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Entidad de Pais
 */
@Entity
@Table(name = "country")
@Data
public class CountryEntity {
     ///Id generado con el codigo del pais ISO 3166-1 alpha-2
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer countryId;
    @Column
    private String countryName;
}
