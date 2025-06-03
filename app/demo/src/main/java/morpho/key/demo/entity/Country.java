package morpho.key.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Collection;
import java.util.UUID;

@Entity
@Table(name = "Country", schema = "taxokey")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
//@NoArgsConstructor
@Builder
@Getter
@Setter
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "countryID", updatable = false, nullable = false)
    private UUID countryID;
    @Column(name = "name")
    private String countryName;
    @Column(name = "code")
    private String countryCode;
    @Column(name = "description", nullable = false)
    private String description;
    @OneToMany(mappedBy = "country")
    private Collection<City> city;
}
