package cashixpay.bus.seat.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SeatDTO {

    private String busId;
    private String busReference;
    private String busName;
    private int seatNumber;
}
