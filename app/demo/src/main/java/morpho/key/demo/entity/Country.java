package morpho.key.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Collection;
import java.util.UUID;

@Entity
@Table(name = "country")
@AllArgsConstructor
@RequiredArgsConstructor
//@NoArgsConstructor
@Builder
@Getter
@Setter
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "countryid", updatable = false, nullable = false)
    private Integer countryID;
    @Column(name = "name")
    private String countryName;
    @Column(name = "code")
    private String countryCode;
    @OneToMany(mappedBy = "country")
    @JsonManagedReference
    private Collection<City> city;
}
