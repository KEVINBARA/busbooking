package cashixpay.bus.travelroute.entities;

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
@Table(name="TravelRoute")
public class TravelRoute {

    @Id
    @GeneratedValue
    private UUID id;

    private String busOwnerId;
    private String busId;
    private String name;
    private String startStop;
    private String endStop;



}
