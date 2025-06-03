package morpho.key.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "city", schema = "taxokey")
@Data
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
@Builder
public class City {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "cityID", updatable = false, nullable = false)
    private UUID cityID;
    @Column(name = "name")
    private String nameCity;
    @Column(name = "code_city")
    private String codeCity;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "countryID")
    private Country country;
}
