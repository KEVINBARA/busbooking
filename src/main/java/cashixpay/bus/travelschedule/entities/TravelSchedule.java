package cashixpay.bus.travelschedule.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="TravelSchedule")
public class TravelSchedule {

    @Id
    @GeneratedValue
    private UUID id;

    private String busId;
    private String busName;
    private String routeId;
    private String routeName;
    private Double price;
    private LocalDateTime startDateTime;
    private LocalDateTime arrivalDateTime;
}
