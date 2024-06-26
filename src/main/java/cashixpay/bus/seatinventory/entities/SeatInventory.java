package cashixpay.bus.seatinventory.entities;

import cashixpay.bus.seatinventory.enumeration.SeatStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="seatInventory")
public class SeatInventory {

    @Id
    @GeneratedValue
    private UUID id;
    private String busOwnerReference;
    private String busReference;
    private String busName;
    private String routeReference;
    private String routeName;
    private String segmentId;
    private int segmentSequence;
    private String startStop;
    private String endStop;
    private String seatId;
    private int seatNumber;
    private String travelScheduleId;
    private LocalDateTime travelDateTime;
    private LocalDateTime arrivalDateTime;
    @Enumerated(EnumType.STRING)
    private SeatStatus seatStatus;

}
