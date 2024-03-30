package cashixpay.bus.information.model;

import cashixpay.bus.information.entities.BusInformation;
import cashixpay.bus.seat.entities.Seat;
import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BusDetails {

    private BusInformation busInformation;

    private List<Seat> seatList;
}
