package cashixpay.bus.seat.entities;


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
@Table(name="seat")
public class Seat {

    @Id
    @GeneratedValue
    private UUID id;
    private String busId;
    private String busName;
    private int seatNumber;

}
