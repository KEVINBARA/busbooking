package cashixpay.bus.reservations.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Reservations")
public class Reservations {

    @Id
    @GeneratedValue
    private UUID id;

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
