package cashixpay.bus.reservations.dto;

import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationsDTO {
    private String firstName;
    private String lastName;

    private String busId;
    private String busName;

    private String routeId;
    private String routeName;

    private String seatId;
    private String seatNumber;
    private String startStop;
    private String endStop;
    private LocalDate bookedDate;
}
