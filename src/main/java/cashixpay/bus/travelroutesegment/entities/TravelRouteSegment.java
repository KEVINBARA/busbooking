package cashixpay.bus.travelroutesegment.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="TravelRouteSegment")
public class TravelRouteSegment {

    @Id
    @GeneratedValue
    private UUID id;

    private String routeReference;
    private int segmentSequence;
    private String startStop;
    private String endStop;

}
