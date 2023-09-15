package cashixpay.bus.busdetails.entities;

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
@Table(name="busInformation")
public class BusInformation {

    @Id
    @GeneratedValue
    private UUID id;

    private String busOwnerId;

    private String name;

    private int numberOfSeats;

    private String plateNumber;
}