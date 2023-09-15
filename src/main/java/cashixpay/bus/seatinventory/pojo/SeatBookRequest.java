package cashixpay.bus.seatinventory.pojo;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Builder

public class SeatBookRequest {

    int seatNumber;
    String routeId;
    String busId;
    Integer startSegmentSequence;
    Integer endSegmentSequence;
    String travelDateTime;
}
