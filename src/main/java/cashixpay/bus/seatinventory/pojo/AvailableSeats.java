package cashixpay.bus.seatinventory.pojo;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Builder

public class AvailableSeats {

    private String busId;
    private String busName;
    private String routeId;
    private String routeName;
    private String startStop;
    private String endStop;
    private Integer startSegmentSequence;
    private Integer endSegmentSequence;
    private int seatNumber;
    private LocalDateTime travelDateTime;
}
