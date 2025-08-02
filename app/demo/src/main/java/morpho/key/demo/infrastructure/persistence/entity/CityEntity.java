package morpho.key.demo.infrastructure.persistence.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "city")
public class CityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cityid", updatable = false, nullable = false)
    private Integer cityId;
    @Column(name = "name")
    private String name;
    /// Entidad Country(Pais)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "countryid")
    @JsonBackReference
    private CountryEntity country;
}
